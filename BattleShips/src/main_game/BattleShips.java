package main_game;
import java.util.Scanner;

import utilities.GridTraversal;
import utilities.ShipPlacement;

public class BattleShips {
	
	public static void main (String args[])
	{
		
		int[][] playerGrid = new int [10][10];
		int[][] aiGrid = new int [10][10];

		GridTraversal.clearGrid(playerGrid);
		GridTraversal.clearGrid(aiGrid);
		
		ShipPlacement.placeShips(playerGrid);
		ShipPlacement.placeShips(aiGrid);
		
		System.out.println("Enemy Grid");
		GridTraversal.printEnemyGrid(aiGrid);		
		
		System.out.println("Your Grid");
		GridTraversal.printYourGrid(playerGrid);
		
		
		
		
		boolean gameActive = true;
		boolean playerTurn = true;
		while(gameActive)
		{
		
			//testShots(playerGrid, aiGrid);
			//testShots(aiGrid, playerGrid);
		
			
			if(playerTurn)
			{
				playerTurn(aiGrid);
				
				if(GridTraversal.checkIfLost(aiGrid) == true)
				{
					gameActive = false;
					System.out.println("PLAYER WINS!");
				}
			}
			else
			{
				aiTurn(playerGrid);
				
				if(GridTraversal.checkIfLost(aiGrid) == true)
				{
					gameActive = false;
					System.out.println("AI WINS!");
				}
			}
			
			
			System.out.println("Enemy Grid");
			GridTraversal.printEnemyGrid(aiGrid);		
			
			System.out.println("Your Grid");
			GridTraversal.printYourGrid(playerGrid);	
			
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
	
	
	private static void playerTurn(int[][] aiGrid){
		
		selectShot(aiGrid);
		
	}
	
	private static void aiTurn(int[][] playerGrid){
		
		selectShot(playerGrid);
		
	}

	
	
	
	private static void selectShot(int[][]grid){
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter an x co-ordinate: ");
		int x = scan.nextInt();
		
		System.out.println("Enter an y co-ordinate: ");
		int y = scan.nextInt();
		scan.nextLine();
		
		x = x-1;
		y = y-1;
		
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

	
	
	
	
	
	private static void testShots (int[][] playerGrid, int[][] aiGrid)
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if((aiGrid[i][j] != 0) && (aiGrid[i][j] != -1))
				{
					System.out.println("HIT!");
					aiGrid[i][j] = 1;
				}
				else
				{
					System.out.println("MISS!");
					aiGrid[i][j] = -1;
				}		
				
				System.out.println("Enemy Grid");
				GridTraversal.printEnemyGrid(aiGrid);		
				
				System.out.println("Your Grid");
				GridTraversal.printYourGrid(playerGrid);
				
				if(GridTraversal.checkIfLost(aiGrid) == true)
				{
					break;
				}
			}
			
			if(GridTraversal.checkIfLost(aiGrid) == true)
			{
				break;
			}
		}
	}

}
