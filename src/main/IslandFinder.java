package main;

public class IslandFinder {
	
	// Test array
	static int[][] islands = { { 1, 1, 0, 0, 0 }, 
							   { 0, 1, 1, 0, 0 }, 
							   { 0, 0, 1, 0, 1 }, 
							   { 1, 0, 0, 0, 1 },
							   { 0, 1, 0, 1, 1 },
							   { 1, 0, 0, 0, 0 } };
	static final int ROWS = 6;
	static final int COLS = 5;
	static int size = 0;
	static int tempSize = 0;
	static int[][] tempIsland = new int[ROWS][COLS];
	static int[][] biggestIsland = new int[ROWS][COLS];
	static int[][] discovered = new int[ROWS][COLS];
	public static void main(String[] args) {

		findBiggestIsland(0, 0);

		for (int[] row : biggestIsland) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	
	
	private static void findBiggestIsland(int row, int col){
		
		for(int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(promising(row,col)){
					tempSize += 1;
					discovered[row][col] = 1;
					tempIsland[row][col] = 1;
					checkAround(row,col);
				}
			}
		
		}
	}
	
	private static void checkAround(int row, int col) {
		// Check above
		if(promising(row-1,col)) {
			checkAround(row-1,col);
		}
		// Check right-above diagonal
		if(promising(row-1,col+1)) {
			checkAround(row-1,col);
		}
		// Check right
		if(promising(row,col+1)) {
			checkAround(row-1,col);
		}
		// Check right-below diagonal
		if(promising(row+1,col+1)) {
			checkAround(row-1,col);
		}
		// Check below
		if(promising(row+1,col)) {
			checkAround(row-1,col);
		}
		// Check left-below diagonal
		if(promising(row+1,col-1)) {
			checkAround(row-1,col);
		}
		// Check left
		if(promising(row,col-1)) {
			checkAround(row-1,col);
		}
		// Check left-above diagonal
		if(promising(row-1,col-1)) {
			checkAround(row-1,col);
		}
	}
		
	private static boolean promising(int row, int col) {

		if(islands[row][col] == 1 && discovered[row][col] == 0){
			tempSize += 1;
			discovered[row-1][col] = 1;
			tempIsland[row][col] = 1;
			return true;
		}
		return false;
	}

}
