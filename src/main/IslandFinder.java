package main;

public class IslandFinder {

	public static void main(String[] args) {

		// Test array
		int[][] islands = { { 1, 1, 0, 0, 0 }, 
							{ 0, 1, 1, 0, 0 }, 
							{ 0, 0, 1, 0, 1 }, 
							{ 1, 0, 0, 0, 1 },
							{ 0, 1, 0, 1, 1 },
							{ 1, 0, 0, 0, 0 } };
		int[][] biggestIsland = findBiggestIsland(islands, 0, 0);

		for (int[] row : biggestIsland) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	static final int ROWS = 6;
	static final int COLS = 5;
	static int size = 0;
	static int tempSize = 0;
	static int[][] tempIsland = new int[ROWS][COLS];
	static int[][] biggestIsland = new int[ROWS][COLS];
	static int[][] discovered = new int[ROWS][COLS];
	
	private static void findBiggestIsland(int[][] islands, int row, int col, int size){
		
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
		
	}
		
		
//		int[][] tempIsland = new int[ROWS][COLS];
//		int size = 0;
//		
//		
//		if (row == ROWS-1) {
//			if (col == COLS-1) {
//				return;
//			}
//			else {
//				if (promising(row,col)){
//					size++;
//					tempIsland[row][col] = 1;
//					discovered[row][col] = 1;
//					size++;
//				}
//				else {
//					if(size > )
//					size = 0;
//					
//				}
//				findBiggestIsland(islands,row, col+1,size);
//			}
//		}
//		else {
//			if (col == COLS-1) {
//				if (promising(row,col)){
//					size++;
//					tempIsland[row][col] = 1;
//					discovered[row][col] = 1;
//					findBiggestIsland(islands,);
//				}
//			}
//			else {
//				if (promising(row,col)){
//					size++;
//					tempIsland[row][col] = 1;
//					discovered[row][col] = 1;
//					findBiggestIsland(islands,);
//				}
//			}
//		}
//				if (promising(row,col)){
//					size++;
//					tempIsland[row][col] = 1;
//					discovered[row][col] = 1;
//				}
//				findBiggestIsland(islands,i);

	private static boolean promising(int row, int col) {

	}

}
