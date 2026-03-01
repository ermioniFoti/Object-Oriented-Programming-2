package model;

import java.io.Serializable;

public class Player implements Comparable<Player>,Serializable {
		
	private String name;
	private int numOfGames;
	private int numOfWins;
	private int numOfDraws;
	private int numOfLoses;
	
	private int recentScore;
	private Game[] recentGames;
	private Game[] bestGames;
	private int numOfBestGames;
	private int numOfRecentGames;
	
	
	public Player(String name) {
		this.name = name;
		this.numOfGames = 0;
		this.numOfWins = 0;
		this.numOfDraws = 0;
		this.numOfLoses =0;
		this.recentScore = 0;
		this.bestGames = new Game[5];
		this.recentGames = new Game[5];
	
	}
	
	public Player() {
		
	}
	
	public void addRecentGames() {
		this.numOfGames++;
	}
	
	public void addWins() {
		this.numOfWins++;
	}
	
	public void addLoses() {
		this.numOfLoses++;
	}
	
	public void addDraws() {
		this.numOfDraws++;
	}
	
	
	public int calculateRecentScore() {
		if(this.numOfGames != 0) {
			this.recentScore = 50*(2*this.numOfWins + this.numOfDraws)/(this.numOfGames);
		}
		else {
			this.recentScore = 0;
		}
		
		return this.recentScore;
	}
	
	public String playersInfo() {
		return("\nTotal games:  "+this.numOfGames
				+"\nWins:  "+this.numOfWins
				+"\nLoses: "+this.numOfLoses
				+"\nDraws: "+this.numOfDraws
				+"\n\n"
				+"\nRecent Score: "+this.recentScore
				);
	}
	
	

	//Getters and Setters

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumOfGames() {
		return numOfGames;
	}


	public void setNumOfGames(int numOfGames) {
		this.numOfGames = numOfGames;
	}


	public int getNumOfWins() {
		return numOfWins;
	}


	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}


	public int getNumOfDraws() {
		return numOfDraws;
	}


	public void setNumOfDraws(int numOfDraws) {
		this.numOfDraws = numOfDraws;
	}


	public int getNumOfLoses() {
		return numOfLoses;
	}


	public void setNumOfLoses(int numOfLoses) {
		this.numOfLoses = numOfLoses;
	}


	


	public float getRecentScore() {
		return recentScore;
	}

	public void setRecentScore(int recentScore) {
		this.recentScore = recentScore;
	}

	public Game[] getRecentGames() {
		return recentGames;
	}


	public void setRecentGames(Game[] recentGames) {
		this.recentGames = recentGames;
	}


	public Game[] getBestGames() {
		return bestGames;
	}


	public void setBestGames(Game[] bestGames) {
		this.bestGames = bestGames;
	}


	public int getNumOfBestGames() {
		return numOfBestGames;
	}


	public void setNumOfBestGames(int numOfBestGames) {
		this.numOfBestGames = numOfBestGames;
	}


	public int getNumOfRecentGames() {
		return numOfRecentGames;
	}


	public void setNumOfRecentGames(int numOfRecentGames) {
		this.numOfRecentGames = numOfRecentGames;
	}

	public String toString() {
		return this.name + ")\t :"  + this.recentScore + "\n";
	}
	@Override
	public int compareTo(Player arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
