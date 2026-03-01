package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PlayersCatalogue {
	static final int MAX_NUMBER_OF_PLAYERS = 50;
	private Player[] players;
	private int numOfPlayers = 4;
	
	
	
	public PlayersCatalogue() {
		players = new Player[MAX_NUMBER_OF_PLAYERS];
		players[0] = new Player("Ermina");
		players[1] = new Player("Antonis");
		players[2] = new Player("Hal");
		players[3] = new Player("Mr.Bean");	
		this.loadPlayers();
		
	}
	
	public void storePlayers() {
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;
		
		try {
			fos = new FileOutputStream("players.txt");
			obj = new ObjectOutputStream(fos);
			for(int i = 0 ; i < numOfPlayers; i++) {
				obj.writeObject(getPlayer(i));
			}
		}
		catch(FileNotFoundException e) {
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
	
	public void loadPlayers() {
		ObjectInputStream objIn = null;
		FileInputStream fis = null;
		int pos = 0;
		int namePos = 0;
		
		try {
			fis = new FileInputStream("players.txt");
			objIn = new ObjectInputStream(fis);
			Player[] listOfPlayers = new Player [20];
			
			while(fis.available()>0) {
				Player p = (Player) objIn.readObject();
				if(p != null) {
					listOfPlayers[pos] = p;
					pos++;
				}
			}
			this.setPlayers(listOfPlayers);
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
	}
	public String[] playersName() {
		String[] allPlayersName = new String [this.numOfPlayers];
		for(int i = 0; i < this.numOfPlayers; i++) {
			allPlayersName[i] = players[i].getName();
		}
		return allPlayersName;
	}
	
	public Player findPlayerByName(String plName) {
		
		for(int i = 0; i < this.numOfPlayers; i++) {
			if(players[i] != null && players[i].getName().equals(plName)) {
				return players[i];
			}
		}
		return null;
	}
	
	public void addPlayer(String plName) {
		if(numOfPlayers < MAX_NUMBER_OF_PLAYERS) {
			this.players[numOfPlayers] = new Player(plName);
			numOfPlayers++;
		}
	}
	
	public Player getPlayer (int i) {
		if( i < this.numOfPlayers ) {
			return players[i];
		}
		else {
			return null;
		}
	}
	
	//Getters and Setters
	
	public Player[] getPlayers() {
		return players;
	}



	public void setPlayers(Player[] players) {
		this.players = players;
	}



	public int getNumOfPlayers() {
		return numOfPlayers;
	}



	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	
	
	
	
}
