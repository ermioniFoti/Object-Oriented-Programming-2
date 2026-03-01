package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.GameController;

public class TopPanel extends JPanel{
	private GameController gc;
	JButton quitBtn;
	JButton addPlayerBtn;
	JButton doneBtn;
	
	public TopPanel(GameController gc) {
		this.gc=gc;
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		quitBtn = new JButton("Quit ");	
		quitBtn.setPreferredSize(new Dimension(100, 40));
		quitBtn.addActionListener((e)->{this.gc.quit();});		
		
		addPlayerBtn = new JButton("Add Player");
		addPlayerBtn.setPreferredSize(new Dimension(100, 40));
		addPlayerBtn.addActionListener((e)->addPlayer());
		
		doneBtn = new JButton("Done");		
		doneBtn.setPreferredSize(new Dimension(100, 40));		
		doneBtn.setEnabled(false);
		doneBtn.addActionListener((e)->this.gc.startAfterDoneBtn());
		
		add(quitBtn);
		add(addPlayerBtn);
		add(doneBtn);					
	}
	
	public void addPlayer() {
		String plName;
		plName = JOptionPane.showInputDialog("Please enter the new player's name");
		
		for(int i = 0; i < gc.getModel().getPlayerCatalogue().getNumOfPlayers(); i++) {
			if(plName.equals(gc.getModel().getPlayerCatalogue().getPlayer(i).getName())) {
				JOptionPane.showMessageDialog(gc.getView(),
						"Player already exists",
						"Try Again!!!",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				gc.getModel().getPlayerCatalogue().addPlayer(plName);
				return;
			}
		}
	}
	
	
	public JButton getQuitBtn() {
		return quitBtn;
	}

	public JButton getAddPlayerBtn() {
		return addPlayerBtn;
	}
	

	public JButton getDoneBtn() {
		return doneBtn;
	}	
	
}
