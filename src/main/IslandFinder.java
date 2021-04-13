package main;

public class IslandFinder {

	
	public static void main(String[] args) {
		
		// Test array
		int[][] islands = {{1, 1, 0, 0, 0},
						   {0, 1, 1, 0, 0},
						   {0, 0, 1, 0, 1},
						   {1, 0, 0, 0, 1},
						   {0, 1, 0, 1, 1},
						   {1, 0, 0, 0, 0}};
		int[][] biggestIsland = findBiggestIsland(islands);
		
		for (int[] row : biggestIsland) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][] findBiggestIsland(int[][] islands){
		
	}

}
