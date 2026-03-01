package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import control.GameController;

public class GameBoard extends GamePanel {
	
	private BoardCell[][] cells;	
	
	public GameBoard(GameController gc) {
		super(gc);
		this.setLayout(null);
		setSize(new Dimension(MainWindow.WIDTH-2*MainWindow.PLAYER_WIDTH,MainWindow.HEIGHT-MainWindow.TOP_HEIGHT));
		this.setBackground(Color.WHITE);
		this.cells = new BoardCell[3][3];
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				BoardCell cell = new BoardCell(gc, row,col);
				cell.setBounds(
						boardZero().x + col*cellSize()+BoardCell.CELL_PADDING,
						boardZero().y+row*cellSize()+BoardCell.CELL_PADDING,
						cellSize()-2*BoardCell.CELL_PADDING,
						cellSize()-2*BoardCell.CELL_PADDING
						);
				this.add(cell);
				this.cells[row][col]=cell;
			}
		}
		
	}
	
	
	private int cellSize() {
		int minDim = Integer.min(this.getWidth(),this.getHeight());
		return minDim/5;
	}
	

	private int boardSize() {
		return 3*cellSize();
	}
	
	private Point boardZero() {
		int x= (this.getWidth() - boardSize())/2;
		int y= (this.getHeight() - boardSize())/2;
		return new Point(x,y);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		Graphics2D g2d = (Graphics2D) g;
		String plName1 = this.getModel().getGamePlayers()[0].getName();
		String plName2 = this.getModel().getGamePlayers()[1].getName();
		
		int x = 200;
		int y = 30;
		
		g2d.setStroke(new BasicStroke(6));
		g2d.setFont(new Font("Current Player",Font.BOLD,20));
		if(getModel().getMoverMark().equals("X") && getModel().getMoves()< 9 && !getModel().endGame()) {
			g2d.drawString(plName1 +" is playing now", x, y);
		}
		else if(getModel().getMoverMark().equals("O") && getModel().getMoves()< 9 && !getModel().endGame()){
			g2d.drawString(plName2 +" is playing now", x, y);
		}
		else if(getModel().getXWin()) {
			g2d.drawString(plName1+" Won", x, y);
		}
		else if(getModel().getOWin() ) {
			g2d.drawString(plName2+" Won",x,y);
		}
		else {
			g2d.drawString("TIE", x, y);
		}
		
		this.drawGrid(g);
		repaint();
		
	}	
	
	public void drawGrid(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(6));
		for (int i=1; i<3; i++) {
			//Draw Vertical Line
			g2d.drawLine(
					boardZero().x +i*cellSize(),boardZero().y, 				// i-based x,  	upperLeft.y 
					boardZero().x+i*cellSize(),boardZero().y+boardSize() 	// i-based x,	boardBottom.y (boardBottom = y + boardSize)
					);
			
			//Draw Horizontal Line
			g2d.drawLine(
					boardZero().x,  boardZero().y+i*cellSize(), 			// upperLeft.x, i-based y
					boardZero().x+boardSize(), boardZero().y+i*cellSize()	// boardRight.x, i-based y (boardRight = x + boardSize)
					);
		}
	}
		

	

}
