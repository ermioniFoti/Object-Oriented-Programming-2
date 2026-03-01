package model;

import java.time.LocalDateTime;

public class Game implements Comparable<Game> {

	@Override
	public int compareTo(Game arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Player[] gamePlayers;
	private int score;
	private LocalDateTime dtf;
	int result;
	
	
	public Game() {
		gamePlayers = new Player[2];
		
		score = 0;
	}

	
	public String  gameInfo(String plName) {
		
		
		
		if(this.gamePlayers[0].getName().equals(plName)) {
			if(result==1) {
				return("\n\n Win vs "+this.gamePlayers[1].getName());
			}
			else if(result==-1) {
				return("\n\n Lose vs"+this.gamePlayers[1].getName());
			}
			else 
				return("\n\n Draw vs "+this.gamePlayers[1].getName());
			
		}
		else if(this.gamePlayers[1].getName().equals(plName)) {
			if(result==1) {
				return("\n\n Win vs "+this.gamePlayers[0].getName());
			}
			else if(result==-1) {
				return("\n\n Lose vs"+this.gamePlayers[0].getName());
			}
			else
				return("\n\n Draw vs "+this.gamePlayers[0].getName());
			
			
			
		}
	
		return null;
	
	}

	public Player[] getGamePlayers() {
		return gamePlayers;
	}


	public void setGamePlayers(Player[] gamePlayers) {
		this.gamePlayers = gamePlayers;
	}
	
	public void setpl (Player pl , int pos) {
		this.gamePlayers[pos] = pl ;
	}
	
	


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}





	public LocalDateTime getDtf() {
		return dtf;
	}


	public void setDtf(LocalDateTime dtf) {
		this.dtf = dtf;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}
	
	
}
