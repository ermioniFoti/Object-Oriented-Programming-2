package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import model.Game;
import model.GameModel;
import model.Player;
import model.PlayersCatalogue;
import view.MainAreaPanel;
import view.MainWindow;

public class GameController extends WindowAdapter {
	MainWindow view;
	GameModel model;
	Game[] games;
	private int numOfGames;
	
	public GameController() {	
		
		games = new Game[30];
		numOfGames = 0;
		
	}
	
	@Override
	public void windowClosing(WindowEvent event) {
		quit();
	}
	
	
	public void start() {
		this.view= new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.model.showHallOfFame();
		this.view.setVisible(true);
		
	}
	
	
	
	public void quit() {		
		System.out.println("bye bye...");		
		System.exit(0);
	}
	
	public void startAfterDoneBtn() {
		this.view.addWindowListener(this);
		
		this.model.getPlayerCatalogue().storePlayers();
		this.addGame(model.getCurrentGame());
		this.model.getCurrentGame().setDtf(LocalDateTime.now());
		this.view.getMainPanel().showCard(MainAreaPanel.HOF);
		
		this.view.getMainPanel().getHallOfFame().getScores().setText(null);;
		
		this.view.getTopPanel().getAddPlayerBtn().setEnabled(true);
		this.model.showHallOfFame();
		this.model = new GameModel(this);
		
		this.model.getPlayerCatalogue().loadPlayers();
		//this.loadGames();
		
        this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(true);
        this.view.getRightPanel().getSelectPlayerBtn().setEnabled(true);
        
        this.view.getRightPanel().getPlName().setText(null);
        this.view.getLeftPanel().getPlName().setText(null);
        this.view.getLeftPanel().getPlStats().setText(null);
        this.view.getRightPanel().getPlStats().setText(null);
        this.view.getTopPanel().getDoneBtn().setEnabled(false);
        
        this.view.getLeftPanel().getStartGameBtn().setEnabled(model.ready());
        this.view.getRightPanel().getStartGameBtn().setEnabled(model.ready());
	}
	
	public void selectPlayer(Player p, int pos) {
		this.model.selectPlayer(p, pos);	
		System.out.println("Player " + pos + " set to " + p);
		
		this.view.getLeftPanel().getStartGameBtn().setEnabled(model.ready());
		this.view.getRightPanel().getStartGameBtn().setEnabled(model.ready());
		
		this.view.getLeftPanel().getStartGameBtn().addActionListener(e->getModel().XPlayersFirstMove());
		this.view.getRightPanel().getStartGameBtn().addActionListener(e->getModel().OPlayersFirsrtMove());
		
		
	}
	
	public void startGame() {
		this.model.setGameBoard(new String[3][3]);
		this.view.getTopPanel().getAddPlayerBtn().setEnabled(false);
		this.view.getMainPanel().showCard(MainAreaPanel.BOARD);
		this.view.getLeftPanel().getStartGameBtn().setEnabled(false);
		this.view.getRightPanel().getStartGameBtn().setEnabled(false);
		this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
		this.view.getRightPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
		
		this.getModel().MrBean();
		this.getModel().Hal();
		
		
	}
		
	public void endOfGame() {
		this.view.getTopPanel().getDoneBtn().setEnabled(true);
		
	}
	
	public void addGame(Game g) {
		if(numOfGames < 30) {
			games[numOfGames] = g;
			numOfGames++;
		}
		else {
			return;
		}
	}
	
	
	
	//public void storeGames() {
		//FileOutputStream fos = null;
		//ObjectOutputStream obj = null;
		
		//try {
			//fos = new FileOutputStream("games.txt");
			//obj = new ObjectOutputStream(fos);
			//for(Game g :this.games) {
				//obj.writeObject(g);
			//}
		//}
		/*catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				obj.close();
				fos.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	
	public void loadGames() {
		ObjectInputStream objIn = null;
		FileInputStream fis = null;
		int pos = 0;
		int namePos = 0;
		
		try {
			fis = new FileInputStream("games.txt");
			objIn = new ObjectInputStream(fis);
			Game[] listOfGames = new Game [20];
			
			while(fis.available()>0) {
				Game g = (Game) objIn.readObject();
				if(g != null) {
					listOfGames[pos] = g;
					pos++;
				}
			}
			this.setGames(listOfGames);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	   catch (ClassNotFoundException e) {
          System.out.println("Class not found for read objects...");
      }
		finally {
			try {
				objIn.close();
				fis.close();
			}
			catch(Exception e) {
				
			}
		}
	}*/
	
	
	public Game[] getGames() {
		return games;
	}

	public void setGames(Game[] games) {
		this.games = games;
	}

	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}
	
}
