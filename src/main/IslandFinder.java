package main;

public class IslandFinder {
	
	// Test array
	static int[][] islands = { { 1, 1, 0, 0, 0 }, 
							   { 0, 1, 1, 0, 0 }, 
							   { 0, 0, 1, 0, 1 }, 
							   { 1, 0, 0, 0, 1 },
							   { 1, 1, 0, 0, 1 },
							   { 1, 1, 1, 0, 0 } };
	static final int ROWS = 6;
	static final int COLS = 5;
	
	static int size = 0;
	static int tempSize = 0;
	
	static int[][] biggestIsland = new int[ROWS][COLS];
	static int[][] tempIsland = new int[ROWS][COLS];
	
	static int[][] discovered = new int[ROWS][COLS];
	
	public static void main(String[] args) {

		findBiggestIsland();
		
		System.out.println("The biggest island is of size " + size + "\n");
		System.out.println("Isolated on the map it appears as below:");
		
		
		for (int[] row : biggestIsland) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	
	
	private static void findBiggestIsland(){
		
		for(int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(promising(i,j)){
					checkAround(i,j);
					if (tempSize > size) {
						biggestIsland = tempIsland;
						size = tempSize;
					}
					tempSize = 0;
					tempIsland = new int[ROWS][COLS];
					
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
			checkAround(row-1,col+1);
		}
		// Check right
		if(promising(row,col+1)) {
			checkAround(row,col+1);
		}
		// Check right-below diagonal
		if(promising(row+1,col+1)) {
			checkAround(row+1,col+1);
		}
		// Check below
		if(promising(row+1,col)) {
			checkAround(row+1,col);
		}
		// Check left-below diagonal
		if(promising(row+1,col-1)) {
			checkAround(row+1,col-1);
		}
		// Check left
		if(promising(row,col-1)) {
			checkAround(row,col-1);
		}
		// Check left-above diagonal
		if(promising(row-1,col-1)) {
			checkAround(row-1,col-1);
		}
	}
		
	private static boolean promising(int row, int col) {

		if(row < 0 || col < 0 || row >= ROWS || col >= COLS)
			return false;
			
		if(islands[row][col] == 1 && discovered[row][col] == 0){
			tempSize += 1;
			discovered[row][col] = 1;
			tempIsland[row][col] = 1;
			return true;
		}
		return false;
	}

}
