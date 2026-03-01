package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.GameController;
import view.MainWindow;

public class HallOfFame extends JPanel{
private GameController gc;
JTextArea Scores;
	
	public HallOfFame(GameController gc) {
		super();
		this.gc=gc;
		
		Scores = new JTextArea();
		Scores.setPreferredSize(new Dimension(MainWindow.WIDTH - 2 * MainWindow.PLAYER_WIDTH , MainWindow.HEIGHT - MainWindow.TOP_HEIGHT));
		Font ScoreFont = new Font("SansSerif", Font.BOLD ,30);
		Scores.setFont(ScoreFont);
		Scores.setBackground(Color.DARK_GRAY);
		Scores.setEnabled(false);
		
		
		this.add(Scores);
	}
	
	
	public JTextArea getScores() {
		return Scores;
	}


	public void setScores(String name) {
		this.Scores.setText(name + Scores.getText());
	}
	
	

	/*@Override
	public void paint(Graphics g) {
		int x = this.getWidth()/2 - 100;
		int y = this.getHeight()/2;		
		g.drawString("Hall Of Fame", x, y);
	}
*/
}
