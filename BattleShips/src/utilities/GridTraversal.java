package utilities;

public class GridTraversal {

	public static void printYourGrid(int[][] grid) {
		for (int i = 0; i < 10; i++) {
			System.out.print("| ");

			for (int j = 0; j < 10; j++) {
				switch (grid[i][j]) {
				case (0): {
					System.out.print("~ | ");
					break;
				}
				case (1): {
					System.out.print("H | ");
					break;
				}
				case (2): {
					System.out.print("A | ");
					break;
				}
				case (3): {
					System.out.print("B | ");
					break;
				}
				case (4): {
					System.out.print("C | ");
					break;
				}
				case (5): {
					System.out.print("S | ");
					break;
				}
				case (6): {
					System.out.print("D | ");
					break;
				}
				case (-1): {
					System.out.print("X | ");
					break;
				}
				}
			}

			System.out.println();
		}

		System.out.println();
	}
	
	public static void printEnemyGrid(int[][] grid) {
		for (int i = 0; i < 10; i++) {
			System.out.print("| ");

			for (int j = 0; j < 10; j++) {
				
				if(grid[i][j] == 1)
				{
					System.out.print("H | ");
				}
				else if(grid[i][j] == -1)
				{
					System.out.print("X | ");
				}
				else
				{
					System.out.print("~ | ");
				}

			}

			System.out.println();
		}

		System.out.println();
	}

	public static boolean checkIfLost(int[][] grid) {
		
		boolean lost = false;
		int hits = 0;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				if(grid[i][j] == 1)
				{
					hits++;
				}

			}
		}
		
		if(hits == 17)
		{
			lost = true;
		}
		
		return lost;
	}
	
	public static void clearGrid(int[][] grid) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				grid[i][j] = 0;

			}
		}
	}

}
