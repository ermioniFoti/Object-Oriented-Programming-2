package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import control.GameController;
import model.Game;
import model.Player;

public class PlayerPanel extends GamePanel{
	
	
	JButton selectPlayerBtn;
	JButton startGameBtn;
	JLabel plMark;
	JTextField plName;
	JTextArea plStats;
	int pos;
	Player currentPlayer = new Player();
	
	
	
	public PlayerPanel(GameController gc, int pos) {
		super(gc);
		this.pos=pos;
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT-MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		this.setBackground(Color.DARK_GRAY);
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		startGameBtn = new JButton("Start Game");
		startGameBtn.setPreferredSize(new Dimension(120,40));
		startGameBtn.setAlignmentX(CENTER_ALIGNMENT);
		startGameBtn.setEnabled(false);
		startGameBtn.addActionListener((e)->{gc.startGame();});
		this.add(startGameBtn);
		
		selectPlayerBtn = new JButton("Select Player");
		selectPlayerBtn.setPreferredSize(new Dimension(120,40));
		selectPlayerBtn.setAlignmentX(CENTER_ALIGNMENT);
		selectPlayerBtn.addActionListener((e)->{changePlayer();});
		this.add(selectPlayerBtn);
		
		plName = new JTextField();
		plName.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,40));
		plName.setAlignmentX(CENTER_ALIGNMENT);
		plName.setHorizontalAlignment(JTextField.CENTER);
		Font nameFont = new Font("SansSerif", Font.BOLD, 40);
		plName.setFont(nameFont);
		plName.setEnabled(false);
		
		
		plMark = new JLabel(pos==0? "X": "O");
		plMark.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,80));
		plMark.setAlignmentX(CENTER_ALIGNMENT);
		plMark.setHorizontalAlignment(JTextField.CENTER);
		plMark.setEnabled(false);
		Font markFont = new Font("SansSerif", Font.BOLD, 90);
		plMark.setFont(markFont);
		plMark.setBackground(Color.BLACK);
		
		
		plStats = new JTextArea(10,100);
		plStats.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,400));
		plStats.setAlignmentX(CENTER_ALIGNMENT);
		plStats.setBackground(Color.DARK_GRAY);
		plStats.setEnabled(false);
		Font statsFont = new Font("SansSerif" , Font.BOLD,20);
		plStats.setFont(statsFont);
		plStats.setMargin(new Insets(10,10,10,10));
		
		
		this.add(plMark);
		this.add(plName);
		this.add(plStats);
	}

	public void changePlayer() {
		//Get the list of all players
		String[] allPlayers = gc.getModel().getPlayerCatalogue().playersName();
		//Arrays.sort(allPlayers);

		//Show Player Selection Dialog
		String selPlayer = (String) JOptionPane.showInputDialog(this, 
				"Choose a Player...",
				"Player selection",
				JOptionPane.PLAIN_MESSAGE,
				null,
				allPlayers,
				currentPlayer
				);
		
		//Set the selected player		
		if(selPlayer != null) {
			if (getModel().getGamePlayers()[pos==0?1:0] != null && selPlayer.equals(getModel().getGamePlayers()[pos==0?1:0].getName())) {
				JOptionPane.showMessageDialog(gc.getView(), 						
						"Player already selected",
						"Ooops...",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

					this.currentPlayer.setName(selPlayer);
				
					gc.selectPlayer(getModel().getPlayerCatalogue().findPlayerByName(selPlayer),pos);
					this.plName.setText(currentPlayer.getName());
					plStats.setText("Player Stats");
					plStats.append(getModel().getPlayerCatalogue().findPlayerByName(selPlayer).playersInfo());
					
					this.repaint();
					
		} 
	}
	
	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public JTextField getPlName() {
		return plName;
	}

	public void setPlName(JTextField plName) {
		this.plName = plName;
	}

	public JButton getSelectPlayerBtn() {
		return selectPlayerBtn;
	}

	public JButton getStartGameBtn() {
		return startGameBtn;
	}

	public void setStartGameBtn(JButton startGameBtn) {
		this.startGameBtn = startGameBtn;
	}

	public JLabel getPlMark() {
		return plMark;
	}

	public void setPlMark(JLabel plMark) {
		this.plMark = plMark;
	}

	public JTextArea getPlStats() {
		return plStats;
	}

	public void setPlStats(JTextArea plStats) {
		this.plStats = plStats;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}	
	
}
