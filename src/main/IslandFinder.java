package main;

public class IslandFinder {
	
	
	static int[][] islands = { { 1, 1, 0, 0, 0 }, // Test array
							   { 0, 1, 1, 0, 0 }, 
							   { 0, 0, 1, 0, 1 }, 
							   { 1, 0, 0, 0, 1 },
							   { 1, 1, 0, 0, 1 },
							   { 1, 1, 1, 0, 0 } };
	static final int ROWS = 6; // Number of rows in the test array
	static final int COLS = 5; // Number of columns in the test array
	
	static int size = 0; // Size of the current biggest island
	static int tempSize = 0; // Size of the island currently being checked
	
	static int[][] biggestIsland = new int[ROWS][COLS]; // Current biggest island
	static int[][] tempIsland = new int[ROWS][COLS]; // Current island being checked
	
	static int[][] discovered = new int[ROWS][COLS]; // Land which has already been accounted for
	
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
	
	
	// Iterate through the islands matrix, assign biggest island and size to global variables
	private static void findBiggestIsland(){
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(promising(i,j)){
					checkAround(i,j); // If land is promising, check around that land for other promising land
					// If current island is bigger than the current biggest, reassign biggest to current
					if (tempSize > size) {
						biggestIsland = tempIsland;
						size = tempSize;
					}
					// Re-initialize temporary variables
					tempSize = 0;
					tempIsland = new int[ROWS][COLS];
					
				}
				
			}
		
		 }
	}
	
	// Checks all directions around a given plot of land, recursively
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
		
	// Decides if a plot of land is promising (is a valid index, is land (== 1), and has not yet been checked)
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
