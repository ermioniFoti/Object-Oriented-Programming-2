package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import control.GameController;
@SuppressWarnings("serial")

public class BoardCell extends GamePanel implements MouseListener {
	public static final int CELL_PADDING = 10;
	int row,col;
	public boolean highlighted;
	
	public BoardCell(GameController gc, int row, int col) {
		super(gc);
		this.setBackground(Color.WHITE);
		this.row = row;
		this.col = col;
		this.addMouseListener(this);
		this.highlighted = false;
		this.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 Random r = new Random();
		String mark = getModel().getBoardMark(this.row,this.col);
		Graphics2D g2d = (Graphics2D) g;
		int size = this.getSize().width - 2*CELL_PADDING;
		g2d.setStroke(new BasicStroke(6));
		if(mark == null) {
			if(highlighted) {
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.fillRect(CELL_PADDING, CELL_PADDING, size, size);
			}
			return;
		} else if (mark.equals("X")) {
			g2d.drawLine(CELL_PADDING, CELL_PADDING, CELL_PADDING + size, CELL_PADDING + size);
			g2d.drawLine(CELL_PADDING + size, CELL_PADDING, CELL_PADDING, CELL_PADDING + size);
		} else if(mark.equals("O")){
			
			g2d.drawOval(CELL_PADDING, CELL_PADDING, size, size);
		}
		else {
			return;
		}
		
		 if (this.getModel().getGamePlayers()[0].getName().equals("Mr.Bean")) {

	            if (this.getModel().getMover() && !this.getModel().endGame()) {

	                int r1 = r.nextInt(3);
	                int r2 = r.nextInt(3);

	                

	                if (getModel().getGameBoard()[r1][r2] == null && !this.getModel().endGame()) {
	                    this.getModel().makeMove(r1, r2);
	                    getModel().checkForResult();
	                }
	            }
	        }
		 if (this.getModel().getGamePlayers()[1].getName().equals("Mr.Bean")) {

	            if (!this.getModel().getMover() && !this.getModel().endGame()) {

	                int r1 = r.nextInt(3);
	                int r2 = r.nextInt(3);

	                

	                if (getModel().getGameBoard()[r1][r2] == null && !this.getModel().endGame()) {
	                    this.getModel().makeMove(r1, r2);
	                    getModel().checkForResult();
	                }
	            }
	        }
		

	        if (this.getModel().getGamePlayers()[0].getName().equals("Hal")) {
	            if ( this.getModel().getMover() &&!this.getModel().endGame()) {
	                Point BestMove = getModel().findBestMove0(getModel().getGameBoard());
	                getModel().makeMove(BestMove.x, BestMove.y);
	                getModel().checkForResult();
	            }
	        }

	            if (this.getModel().getGamePlayers()[1].getName().equals("Hal")) {
	                if (!this.getModel().getMover() && !this.getModel().endGame()) {
	                    Point BestMove = getModel().findBestMove1(getModel().getGameBoard());
	                    getModel().makeMove(BestMove.x, BestMove.y);
	                    getModel().checkForResult();
	                }
	            }


	        }
		
	
	
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked on cell" + this);
		if(getModel().inPlay() && !getModel().endGame()) {
			
			getModel().makeMove(row, col);
			repaint();
			getModel().checkForResult();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse enterd cell "+this);
		this.highlighted = true;
		repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited on cell"+this);
		this.highlighted = false;
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
