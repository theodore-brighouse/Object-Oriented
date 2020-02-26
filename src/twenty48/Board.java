package twenty48;

public class Board {
	private int[][] board;
	
	public void shift(Direction direction) {
		if (direction.equals(Direction.RIGHT)) {
			shiftRight(board);
		}
	}
	
	
	
	
	
	private int[][] shiftRight(int[][] board) {
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
}
