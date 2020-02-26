package twenty48;

public class Utilities2048 {
	
	/**
	 * returns how many digits are in an integer
	 * @param number
	 * @return
	 */
	public static int checkDigits(int number) {
		int digits = 0;
		if (number == 0) {
			return 1;
		}
		while (number > 0) {
			number = number / 10;
			digits ++;
		}return digits;
	}
	
	public static int[][] makeDigitsEven(int[][] arry) {
		for(int i=0; i < arry.length; i++ ) {
			for(int j=0; j < arry[0].length; j++) {
				if (arry[i][j]%2 != 0) {
					arry[i][j] = arry[i][j]-1;				
				}
			}
				
		}return arry;
	}
	
}