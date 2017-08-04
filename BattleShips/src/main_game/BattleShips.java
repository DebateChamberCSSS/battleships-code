package main_game;
import java.util.Scanner;

import utilities.GridTraversal;
import utilities.ShipPlacement;
import utilities.TestGrid;

public class BattleShips {
	
	public static void main (String args[])
	{
		
		//Board set-up
		int[][] playerGrid = new int [10][10];
		int[][] aiGrid = new int [10][10];

		//Initialise to empty
		GridTraversal.clearGrid(playerGrid);
		GridTraversal.clearGrid(aiGrid);
		
		//Randomly place ships
		ShipPlacement.placeShips(playerGrid);
		ShipPlacement.placeShips(aiGrid);
		
		//Print enemy grid
		System.out.println("Enemy Grid");
		GridTraversal.printEnemyGrid(aiGrid);		
		
		//Print player grid
		System.out.println("Your Grid");
		GridTraversal.printPlayerGrid(playerGrid);
		
		
		//Game loop variables
		boolean gameActive = true;
		boolean playerTurn = true;
		
		//Game loop
		while(gameActive)
		{
			if(playerTurn)
			{
				//Method to allow manual input of co-ordinates. Shot is taken at the board taken as parameter.
				manualShot(aiGrid);
				
				//Check  if player has won.
				if(GridTraversal.checkIfLost(aiGrid) == true)
				{
					gameActive = false;
					System.out.println("PLAYER WINS!");
				}
			}
			else
			{
				//Method to select a shot through AI. Shot is taken at the board taken as parameter.
				aiShot(playerGrid);
				
				//Check if AI has won.
				if(GridTraversal.checkIfLost(aiGrid) == true)
				{
					gameActive = false;
					System.out.println("AI WINS!");
				}
			}
			
			
			//Print enemy grid.
			System.out.println("Enemy Grid");
			GridTraversal.printEnemyGrid(aiGrid);		
			
			//Print player grid.
			System.out.println("Your Grid");
			GridTraversal.printPlayerGrid(playerGrid);	
			
			
			//Change turns.
			if(playerTurn == true)
			{
				playerTurn = false;
			}
			else
			{
				playerTurn = true;
			}
			
		}
	}

	
	//ADD CODE IN FOR AI METHOD WHICH DECIDES COORDINATES
	private static void aiShot(int[][] playerGrid){
		
		/*
		 * 
		 * 
		 * ADD AI CODE IN HERE!!!
		 * 
		 * 
		 */
		
		//Remove this to add code.
		manualShot(playerGrid);
		
	}

	
	
	//Method for manually selecting a co-ordinate.
	private static void manualShot(int[][]grid){
		
		//Input scanner (DON'T CLOSE!!!)
		Scanner scan = new Scanner(System.in);

		//Select x co-ordinate
		System.out.println("Enter an x co-ordinate: ");
		int x = scan.nextInt();
		
		//Select y co-ordinate
		System.out.println("Enter an y co-ordinate: ");
		int y = scan.nextInt();
		scan.nextLine();
		
		//Adjust co-ordinates to array indexing
		x = x-1;
		y = y-1;
		
		
		/*
		 * Update for hits:
		 * 
		 * -1 = Already missed
		 * 0 = Empty
		 * 1 = Hit
		 * 2-6 = Different ship types
		 * 
		 */
		if((grid[x][y] != 0) && (grid[x][y] != -1))
		{
			System.out.println("HIT!");
			grid[x][y] = 1;
		}
		else
		{
			System.out.println("MISS!");
			grid[x][y] = -1;
		}
		
	}
}
