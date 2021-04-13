package main;

public class IslandFinder {

	public static void main(String[] args) {

		// Test array
		int[][] islands = { { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
				{ 0, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 } };
		int[][] biggestIsland = findBiggestIsland(islands);

		for (int[] row : biggestIsland) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	private static int[][] findBiggestIsland(int[][] islands){
		
		int rows = islands.length;
		int cols = islands[0].length;
		
		int[][] discovered = new int[rows][cols];
		int[][] biggestIsland = new int[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(islands[i][j] == 1) {
					while (promising(i,j)){
						discovered[i][j] = 1;
					}
				}
			}
		}
	}
	
	private static boolean promising(int row, int col) {
		
	}

}
