package utilities;

import java.util.Random;

public class ShipPlacement {

	public static void placeShips(int[][] grid) {

		// Place carrier
		determinePosition(grid, 5, 2);

		// Place battleship
		determinePosition(grid, 4, 3);

		// Place cruiser
		determinePosition(grid, 3, 4);

		// Place submarine
		determinePosition(grid, 3, 5);

		// Place destroyer
		determinePosition(grid, 2, 6);

	}

	private static void determinePosition(int[][] grid, int length, int shipNo) {
		Random rand = new Random();
		int main = rand.nextInt(10);
		int subsidiary = rand.nextInt(length);
		boolean vertical = rand.nextBoolean();

		// Place battleship
		boolean empty = false;
		while (empty == false) {
			main = rand.nextInt(10);
			subsidiary = rand.nextInt(length);
			vertical = rand.nextBoolean();

			if (vertical) {
				empty = checkIfEmpty(grid, main, subsidiary, length, vertical);
			} else {
				empty = checkIfEmpty(grid, subsidiary, main, length, vertical);
			}
		}

		if (vertical == true) {
			place(grid, main, subsidiary, length, vertical, shipNo);
		} else {
			place(grid, subsidiary, main, length, vertical, shipNo);
		}
	}

	private static void place(int[][] grid, int x, int y, int length, boolean vertical, int shipNo) {
		for (int i = 0; i < length; i++) {
			if (vertical == true) {
				grid[x][y + i] = shipNo;
			} else {
				grid[x + i][y] = shipNo;
			}
		}
	}

	private static boolean checkIfEmpty(int[][] grid, int x, int y, int length, boolean vertical) {

		boolean noCollision = true;

		for (int i = 0; i < length; i++) {
			if (vertical) {
				if (grid[x][y + i] != 0) {
					noCollision = false;
				}
			} else {
				if (grid[x + i][y] != 0) {
					noCollision = false;
				}
			}
		}
		return noCollision;
	}
}
