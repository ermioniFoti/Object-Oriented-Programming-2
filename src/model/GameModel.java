package model;

import java.awt.Point;
import java.time.LocalDateTime;
import java.util.Random;

import control.GameController;

public class GameModel {
	PlayersCatalogue  playerCatalogue;
	Player [] gamePlayers;		
	String[][] gameBoard;
	GameController gc;
	Boolean mover;
	Boolean XWin;
	Boolean OWin;
	Boolean draw;
	int moves;
	Game currentGame;
	private Game[] playersGame;
	LocalDateTime dtf;
	
	public GameModel(GameController gc) {
		this.gc=gc;
		gamePlayers = new Player[2];
		gameBoard= null;
		playerCatalogue= new PlayersCatalogue();
		this.playerCatalogue.loadPlayers();
		XWin = false;
		OWin = false;
		draw = false;
		moves = 0;
		currentGame = new Game();
		playersGame = new Game[30];
		
	}
	
	
	
	public void checkDimValidity(int row,int col) {
		if(row < 0 || col < 0 || row > 2 || col > 2) {
			throw new IndexOutOfBoundsException(row+","+col+"is not a valid board cell");	
		}
	}
	
	public void checkMoveValidity(int row,int col) {
		checkDimValidity(row, col);
		if(gameBoard[row][col]!=null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}
	
	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}
	
	public void makeMove(int row,int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col] = getMoverMark();
		mover=!mover;
		moves ++;
	}
	
	public void XPlayersFirstMove() {
		this.mover = true;
	}
	
	public void OPlayersFirsrtMove() {
		this.mover = false;
	}
	
	
	public String getMoverMark() {
		return mover? "X":"O";
	}
	
	public void selectPlayer(Player player, int pos) {
		if (pos<0 && pos>1)
			return;
		gamePlayers[pos] = player;
		this.currentGame.setpl(player, pos);
	}
	
	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] !=null);
	}
	
	
	public void startGame() {
		gameBoard= new String[3][3];
	}
	
	
	public boolean inPlay() {
		return gameBoard !=null;
	}
	
	public boolean NoPlay() {
		return !inPlay();
	}
	
	public boolean endGame() {
		if(XWin || OWin || draw) {
			gc.endOfGame();
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addGamestoPlayer() {
		for (int i = 0; i < playersGame.length; i++) {
			playersGame[i] = currentGame;
		}
	}
	

		
	
	public void XWinEnd(){
		System.out.println("X wins");
		XWin = true;
		addResultToPlayers();
		gameData(1) ;
		this.currentGame.setDtf(dtf.now());
		
		this.gc.addGame(currentGame);
		gc.endOfGame();
		
	}
	
	public void OWinEnd() {
		System.out.println("O wins");
		OWin = true;
		addResultToPlayers();
		gameData(-1) ;
		this.currentGame.setDtf(dtf.now());
		

		this.gc.addGame(currentGame);
		gc.endOfGame();
	}
	
	public void drawWinEnd() {
		if(!XWin && !OWin && moves == 9){
			System.out.println("draw");
			draw = true;
			addResultToPlayers();
			gameData(0) ;
			this.currentGame.setDtf(dtf.now());

			this.gc.addGame(currentGame);
			gc.endOfGame();
		}
	}
	
	public void gameData (int result) {
		this.currentGame.setResult(result);
	}
	
	
	public void checkForResult() {
		if((gameBoard[0][0]!=null && gameBoard[1][1]!=null && gameBoard[2][2]!=null)) {
			if((gameBoard[0][0].equals("X")) && (gameBoard[1][1].equals("X")) && (gameBoard[2][2].equals("X"))) {
				XWinEnd();
				
			}
		}
		if((gameBoard[0][0]!=null && gameBoard[1][0]!=null && gameBoard[2][0]!=null)) {
			if((gameBoard[0][0].equals("X")) && (gameBoard[1][0].equals("X")) && (gameBoard[2][0].equals("X"))) {
				XWinEnd();
			}
		}
		if((gameBoard[2][0]!=null && gameBoard[1][1]!=null && gameBoard[0][2]!=null)) {
			if((gameBoard[2][0].equals("X")) && (gameBoard[1][1].equals("X")) && (gameBoard[0][2].equals("X"))) {
				XWinEnd();
			}
		}
		if((gameBoard[0][2]!=null && gameBoard[1][2]!=null && gameBoard[2][2]!=null)) {
			if((gameBoard[0][2].equals("X")) && (gameBoard[1][2].equals("X")) && (gameBoard[2][2].equals("X"))) {
				XWinEnd();
			}
		}
		if((gameBoard[0][1]!=null && gameBoard[1][1]!=null && gameBoard[2][1]!=null)) {
			if((gameBoard[0][1].equals("X")) && (gameBoard[1][1].equals("X")) && (gameBoard[2][1].equals("X"))) {
				XWinEnd();
			}
		}
		if((gameBoard[0][0]!=null && gameBoard[0][1]!=null && gameBoard[0][2]!=null)) {
			if((gameBoard[0][0].equals("X")) && (gameBoard[0][1].equals("X")) && (gameBoard[0][2].equals("X"))) {
				XWinEnd();
			}
		}
		if((gameBoard[1][0]!=null && gameBoard[1][1]!=null && gameBoard[1][2]!=null)) {
			if((gameBoard[1][0].equals("X")) && (gameBoard[1][1].equals("X")) && (gameBoard[1][2].equals("X"))) {
				XWinEnd();
			}
		}
		if((gameBoard[2][0]!=null && gameBoard[2][1]!=null && gameBoard[2][2]!=null)) {
			if((gameBoard[2][0].equals("X")) && (gameBoard[2][1].equals("X")) && (gameBoard[2][2].equals("X"))) {
				XWinEnd();
			}
		}
		
		if((gameBoard[0][0]!=null && gameBoard[1][1]!=null && gameBoard[2][2]!=null)) {
			if((gameBoard[0][0].equals("O")) && (gameBoard[1][1].equals("O")) && (gameBoard[2][2].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[0][0]!=null && gameBoard[1][0]!=null && gameBoard[2][0]!=null)) {
			if((gameBoard[0][0].equals("O")) && (gameBoard[1][0].equals("O")) && (gameBoard[2][0].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[2][0]!=null && gameBoard[1][1]!=null && gameBoard[0][2]!=null)) {
			if((gameBoard[2][0].equals("O")) && (gameBoard[1][1].equals("O")) && (gameBoard[0][2].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[0][2]!=null && gameBoard[1][2]!=null && gameBoard[2][2]!=null)) {
			if((gameBoard[0][2].equals("O")) && (gameBoard[1][2].equals("O")) && (gameBoard[2][2].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[0][1]!=null && gameBoard[1][1]!=null && gameBoard[2][1]!=null)) {
			if((gameBoard[0][1].equals("O")) && (gameBoard[1][1].equals("O")) && (gameBoard[2][1].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[0][0]!=null && gameBoard[0][1]!=null && gameBoard[0][2]!=null)) {
			if((gameBoard[0][0].equals("O")) && (gameBoard[0][1].equals("O")) && (gameBoard[0][2].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[1][0]!=null && gameBoard[1][1]!=null && gameBoard[1][2]!=null)) {
			if((gameBoard[1][0].equals("O")) && (gameBoard[1][1].equals("O")) && (gameBoard[1][2].equals("O"))) {
				OWinEnd();
			}
		}
		if((gameBoard[2][0]!=null && gameBoard[2][1]!=null && gameBoard[2][2]!=null)) {
			if((gameBoard[2][0].equals("O")) && (gameBoard[2][1].equals("O")) && (gameBoard[2][2].equals("O"))) {
				OWinEnd();
			}
		}
		
		drawWinEnd();
	}
	
	public void addResultToPlayers(){
		
		//player 0
		
		for(int i = 0; i < getPlayerCatalogue().getNumOfPlayers(); i++) {
			if(getGamePlayers()[0].getName().equals(getPlayerCatalogue().getPlayer(i).getName())) {
				getPlayerCatalogue().getPlayer(i).addRecentGames();
				if(XWin) {
					getPlayerCatalogue().getPlayer(i).addWins();
					getPlayerCatalogue().getPlayer(i).calculateRecentScore();
					break;
				}
				else if(OWin) {
					getPlayerCatalogue().getPlayer(i).addLoses();
					getPlayerCatalogue().getPlayer(i).calculateRecentScore();
					break;
				}
				else {
					getPlayerCatalogue().getPlayer(i).addDraws();
					getPlayerCatalogue().getPlayer(i).calculateRecentScore();
					break;
				}
			}
		}
			
	//player 1
		for(int i = 0; i < getPlayerCatalogue().getNumOfPlayers(); i++) {
			if(getGamePlayers()[1].getName().equals(getPlayerCatalogue().getPlayer(i).getName())) {
				getPlayerCatalogue().getPlayer(i).addRecentGames();
				if(XWin) {
					getPlayerCatalogue().getPlayer(i).addLoses();
					getPlayerCatalogue().getPlayer(i).calculateRecentScore();
					break;
				}
				else if(OWin) {
					getPlayerCatalogue().getPlayer(i).addWins();
					getPlayerCatalogue().getPlayer(i).calculateRecentScore();
					break;
				}
				else {
					getPlayerCatalogue().getPlayer(i).addDraws();
					getPlayerCatalogue().getPlayer(i).calculateRecentScore();
					break;
				}
			}
		}
		
		
	}
	
	
	
	public void MrBean() {
        Random r=new Random();
        if ((this.getGamePlayers()[1].getName().equals("Mr.Bean") && moves==0 && !getMover()) ||
                (this.getGamePlayers()[0].getName().equals("Mr.Bean") && moves==0 && getMover()) ) {

            if (!this.endGame()) {


                int r1 = r.nextInt(3);
                int r2 = r.nextInt(3);


                if (getGameBoard()[r1][r2] == null && !this.endGame()) {
                    this.makeMove(r1, r2);
                    checkForResult();

                }
            }
        }
    }

    public void Hal(){

        if(this.getGamePlayers()[0].getName().equals("Hal") && moves==0 && getMover() )
        {
            if(!this.endGame()){

                Point BestMove = findBestMove0(gameBoard);
                makeMove(BestMove.x, BestMove.y);

            }
        }

        if(this.getGamePlayers()[1].getName().equals("Hal") && moves==0 && !getMover())
        {
            if(!this.endGame())
            {
                Point BestMove=findBestMove0(gameBoard);
                makeMove(BestMove.x,BestMove.y);
            }
        }

    }
	
	

	static Boolean isMovesLeft(String[][] board)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j]==null)
                    return true;
        return false;
    }
    //======================================================================================================
                          // PERFECT PLAYER  in position 0( X )
   static int evaluate0(String[][] b)
    {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if(b[row][0]!=null &&  b[row][1]!=null && b[row][2]!=null) {
                if (b[row][0].equals(b[row][1]) &&
                        b[row][1].equals(b[row][2])) {
                    if (b[row][0].equals("X"))
                        return +1;
                    else if (b[row][0].equals("O"))
                        return -1;
                }
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if(b[0][col]!=null  && b[1][col]!=null && b[2][col]!=null) {
                if (b[0][col].equals(b[1][col]) &&
                        b[1][col].equals(b[2][col])) {
                    if (b[0][col].equals("X"))
                        return +1;

                    else if (b[0][col].equals("O"))
                        return -1;
                }
            }
        }

        // Checking for Diagonals for X or O victory.
        if(b[0][0]!=null && b[1][1]!=null && b[2][2]!=null) {
            if (b[0][0].equals(b[1][1]) && b[1][1].equals(b[2][2])) {
                if (b[0][0].equals("X"))
                    return +1;
                else if (b[0][0].equals("O"))
                    return -1;
            }
        }

        if(b[0][2]!=null && b[1][1]!=null && b[2][0]!=null) {
            if (b[0][2].equals(b[1][1]) && b[1][1].equals(b[2][0])) {
                if (b[0][2].equals("X"))
                    return +1;
                else if (b[0][2].equals("O"))
                    return -1;
            }
        }

        // Else if none of them have won then return 0
        return 0;
    }


/*
     This is the minimax function. It considers all
     the possible ways the game can go and returns
     the value of the board

 */

    public int minimax0(String[][] board, int depth, Boolean isMax)
    {
        int score = evaluate0(board);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 1)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -1)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (!isMovesLeft(board))
            return 0;

        // If this maximizer's move

        if (isMax)
        {
           int  best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]==null)
                    {
                        // Make the move
                       board[i][j]="X";
                        //makeMove(i,j);

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax0(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = null;
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
           int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j] ==null)
                    {
                        // Make the move
                        board[i][j] = "O";
                        //makeMove(i,j);

                        best = Math.min(best, minimax0(board,
                                depth + 1, !isMax));

                        // Undo the move
                       board[i][j] = null;
                    }
                }
            }
            return best;
        }
    }

    // This will return the best possible
// move for the player
    public Point findBestMove0(String[][] board)
    {
        int bestVal = -1000;
        //Move bestMove = new Move();

        Point p = new Point();
        p.x = -1;
        p.y = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            // Check if cell is empty
            if (board[i][j] == null) {
                // Make the move
                board[i][j] = "X";

                // compute evaluation function for this
                // move.
                int moveVal = minimax0(board, 0, false);

                // Undo the move
                board[i][j] = null;

                // If the value of the current move is
                // more than the best value, then update
                // best/
                if (moveVal > bestVal) {
                    p.x = i;
                    p.y = j;

                    bestVal = moveVal;

                }
            }
        }

    }


        System.out.printf("The value of the best Move " +
                "is : %d\n\n", bestVal);
        return p;
    }

    
/*======================================================================================================
                     PERFECT PLAYER  in position 1( O )

 */

    
    static int evaluate1(String[][] b)
    {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if(b[row][0]!=null &&  b[row][1]!=null && b[row][2]!=null) {
                if (b[row][0].equals(b[row][1]) &&
                        b[row][1].equals(b[row][2])) {
                    if (b[row][0].equals("X"))
                        return -1;
                    else if (b[row][0].equals("O"))
                        return +1;
                }
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if(b[0][col]!=null  && b[1][col]!=null && b[2][col]!=null) {
                if (b[0][col].equals(b[1][col]) &&
                        b[1][col].equals(b[2][col])) {
                    if (b[0][col].equals("X"))
                        return -1;

                    else if (b[0][col].equals("O"))
                        return +1;
                }
            }
        }

        // Checking for Diagonals for X or O victory.
        if(b[0][0]!=null && b[1][1]!=null && b[2][2]!=null) {
            if (b[0][0].equals(b[1][1]) && b[1][1].equals(b[2][2])) {
                if (b[0][0].equals("X"))
                    return -1;
                else if (b[0][0].equals("O"))
                    return +1;
            }
        }

        if(b[0][2]!=null && b[1][1]!=null && b[2][0]!=null) {
            if (b[0][2].equals(b[1][1]) && b[1][1].equals(b[2][0])) {
                if (b[0][2].equals("X"))
                    return -1;
                else if (b[0][2].equals("O"))
                    return +1;
            }
        }

        // Else if none of them have won then return 0
        return 0;
    }

    public int minimax1(String[][] board, int depth, Boolean isMax)
    {
        int score = evaluate1(board);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 1)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -1)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (!isMovesLeft(board))
            return 0;

        // If this maximizer's move

        if (isMax)
        {
            int  best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]==null)
                    {
                        // Make the move
                        board[i][j]="O";
                        //makeMove(i,j);

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax1(board, depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = null;
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j] ==null)
                    {
                        // Make the move
                        board[i][j] = "X";
                        //makeMove(i,j);

                        best = Math.min(best, minimax1(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = null;
                    }
                }
            }
            return best;
        }
    }

    // This will return the best possible
// move for the player
    public Point findBestMove1(String[][] board)
    {
        int bestVal = -1000;
        //Move bestMove = new Move();

        Point p =new Point();
        p.x=-1;
        p.y=-1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board[i][j] == null) {
                    // Make the move
                    board[i][j] = "O";

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax1(board, 0, false);

                    // Undo the move
                    board[i][j] = null;

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal) {
                        p.x = i;
                        p.y = j;

                        bestVal = moveVal;

                    }
                }
            }

        }


        System.out.printf("The value of the best Move " +
                "is : %d\n\n", bestVal);
        return p;
    }

		
		public void showHallOfFame() {
			
			for(int i = 0 ; i < getPlayerCatalogue().getNumOfPlayers(); i++) {
				
				this.gc.getView().getMainPanel().getHallOfFame().setScores(this.playerCatalogue.getPlayers()[i].toString());
				
			}
			
		}
	
	
	public Player[] getGamePlayers() {
		return gamePlayers;
	}
	

	public String[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public PlayersCatalogue getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayersCatalogue playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}

	public Boolean getXWin() {
		return XWin;
	}

	public void setXWin(Boolean xWin) {
		XWin = xWin;
	}

	public Boolean getOWin() {
		return OWin;
	}

	public void setOWin(Boolean oWin) {
		OWin = oWin;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public Boolean getMover() {
		return mover;
	}

	public void setMover(Boolean mover) {
		this.mover = mover;
	}



	public Game getCurrentGame() {
		return currentGame;
	}



	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}
	
	
	
	
	
	
		
}
