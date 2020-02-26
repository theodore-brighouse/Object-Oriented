package twenty48;

import java.util.Random;
import java.util.Scanner;

public class TwentyFourtyEight {	
	public static void main (String[] args) {

		int[][] board = TwentyFourtyEight.gameInit();
		TwentyFourtyEight.spawnTile(board);
		TwentyFourtyEight.displayBoard(board);
		
		while (!didWin(board)) {
			String input = TwentyFourtyEight.readInput();
			TwentyFourtyEight.updateBoard(board, input);
			TwentyFourtyEight.displayBoard(board);
		}
		TwentyFourtyEight.displayWin();
	}
	
	/**
	 * Initialize the game board by filling up the board with 0's
	 * 
	 * returns the empty board
	 * 
	 * OPTIONALLY
	 * 	Ask user for board size and use that instead
	 */
	public static int[][] gameInit() {   
		int[][] boardStart = {{0,0,0,0},
		                     {0,0,0,0},
		                     {0,0,0,0},
		                     {0,0,0,0}};
		
		return boardStart;
	}
	
	/**
	 * Ask the user for input. 
	 * Possible inputs are:
	 * 		[w], [a], [s], [d]
	 * if the user inputs anything that is NOT w, a, s or d, do not update board, instead let the user know they input 
	 * something unexpected, and ask for input again.
	 */
	public static String readInput() {
		System.out.println("input direction: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		return input;

	}

	/**
	 * if user inputs w, move tiles up. If they input a, move tiles left. etc;
	 * 
	 * If two tiles are the same, merge them together
	 * If tiles are at their border position, don't move them.
	 * If tiles are NOT the same, colliding tile doesn't move / stops at other tile.
	 * 
	 */
	public static void updateBoard(int[][] board, String input) {
		if (input.toUpperCase().equals("A")) {
			TwentyFourtyEight.shiftLeft(board);
			TwentyFourtyEight.spawnTile(board);
		}
		else if (input.toUpperCase().equals("W")) {
			TwentyFourtyEight.shiftUp(board);
			TwentyFourtyEight.spawnTile(board);
		}
		else if (input.toUpperCase().equals("D")) {
			TwentyFourtyEight.shiftRight(board);
			TwentyFourtyEight.spawnTile(board);
		}
		else if (input.toUpperCase().equals("S")) {
			TwentyFourtyEight.shiftDown(board);
			TwentyFourtyEight.spawnTile(board);
		}else {
			System.out.println("Pease input W A S or D");
		}
	}
	
	/**
	 * shifts tiles left
	 * 
	 * @param board is the board we want to shift on
	 * @return the shifted board
	 */
	public static int[][] shiftLeft(int[][] board) {
		for (int i = 0; i < board.length; i++ ) {
			for (int j = 1; j < board[0].length; j++ ) {
				while (j != 0 && board[i][j-1] == 0 && board[i][j] != 0 ){
					board[i][j-1] = board[i][j];
					board[i][j] = 0;
					j--;
				}
				if (j!=0 && board[i][j-1] == board[i][j]) {
					board[i][j-1] = board[i][j] + board[i][j-1];
					board[i][j] = 0;
					if (board[i][j-1] != 0) {
						board[i][j-1] = board[i][j-1]+1;
					}
				}
		     }
		}
		Utilities2048.makeDigitsEven(board);
		return board;
	} 
	/**
	 * shifts tiles right
	 * 
	 * @param board is the board we want to shift on
	 * @return the shifted board
	 */
	public static int[][] shiftRight(int[][] board) {
		for (int i = 0; i < board.length; i++ ) {
			for (int j = board[0].length-2; j >= 0; j-- ) {
				while (j != board[0].length-1 && board[i][j+1] == 0 && board[i][j] != 0 ){
					board[i][j+1] = board[i][j];
					board[i][j] = 0;
					j++;
				}
				if (j!= board[0].length-1 && board[i][j+1] == board[i][j]) {
					board[i][j+1] = board[i][j] + board[i][j+1];
					board[i][j] = 0;
					if (board[i][j+1] != 0) {
						board[i][j+1] = board[i][j+1];
					}
					
				}
		     }
		}
		Utilities2048.makeDigitsEven(board);
		return board;
	}
	/**
	 * shifts tiles down
	 * 
	 * @param board is the board we want to shift on
	 * @return the shifted board
	 */
	public static int[][] shiftDown(int[][] board) {
		for (int i = board.length-2; i >=0; i-- ) {
			for (int j = board[0].length-1; j >=0; j-- ) {
				while (i != board.length-1 && board[i+1][j] == 0 && board[i][j] != 0 ){
					board[i+1][j] = board[i][j];
					board[i][j] = 0;
					i++;
				}
				if (i!=board.length-1 && board[i+1][j] == board[i][j]) {
					board[i+1][j] = board[i][j] + board[i+1][j];
					board[i][j] = 0;
					if (board[i+1][j] != 0) {
						board[i+1][j] = board[i+1][j]+1;
					}
					
					}
		     }
		}
		Utilities2048.makeDigitsEven(board);
		return board;
	}
	/**
	 * shifts tiles up
	 * 
	 * @param board is the board we want to shift on
	 * @return the shifted board
	 */
	public static int[][] shiftUp(int[][] board) {
		for (int i = 0; i < board.length; i++ ) {
			for (int j = board[0].length-1; j >=0; j-- ) {
				while (i != 0 && board[i-1][j] == 0 && board[i][j] != 0 ){
					board[i-1][j] = board[i][j];
					board[i][j] = 0;
					i--;
				}
				if (i!=0 && board[i-1][j] == board[i][j]) {
					board[i-1][j] = board[i][j] + board[i-1][j];
					board[i][j] = 0;
					if (board[i][j-1] != 0) {
						board[i][j-1] = board[i-1][j]+1;
					}
				}
		     }
		}
		Utilities2048.makeDigitsEven(board);
		return board;
	}
	
	/**
	 * Spawns a 2 or a 4 at a random EMPTY space on the board
	 * 
	 * @param board
	 * @return board
	 */
 	public static int[][] spawnTile(int[][] board) {
	int twoOrFour = new Random().nextInt(4);
    int xPosision = new Random().nextInt(4);
    int yPosision = new Random().nextInt(4);
		while (board[xPosision][yPosision] != 0) {
		     xPosision = new Random().nextInt(4);
		     yPosision = new Random().nextInt(4);

		}
		if (twoOrFour == 1) {
		board[xPosision][yPosision]=4;
		}else {
			board[xPosision][yPosision]=2; 
		}
		return board;
			
		
	}
	
	
	/**
	 * print the current state of the board. 
	 * 
	 * OPTIONAL:
	 * 	If some tiles have more digits than others, alter the amount of spaces between it and the next tile
	 */
	public static void displayBoard(int[][] board) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j < board[i].length; j++) {
				int spaces = 7-Utilities2048.checkDigits(board[i][j]);
				
				for (int k=0; k<spaces; k++) {
					System.out.print(" ");
				}

				System.out.print(board[i][j]);
				
			}
			System.out.println("\n");
		}
	}	
	
	/**
	 * print a "you win!" message
	 */
	public static void displayWin() {
		System.out.println("YOU WIN!");
	}
	
	/**
	 * check if there is a 2048 on the board. If there is, return true
	 */
	public static boolean didWin(int[][] board) {
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j < board[i].length; j++) {
				if (board[i][j] == 2048) {
				return true;
				}
			}
		}return false;
		
		
	}
	/**
	 * checks if no moves can be performed on the board. If there is, return true
	 * 
	 * @param board
	 * @return true if no move available
	 */
	public static boolean didLose (int[][] board) {
		return true;
	}
}