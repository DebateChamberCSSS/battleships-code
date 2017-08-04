package utilities;

public class TestGrid {
	
	public static void testShots (int[][] playerGrid, int[][] aiGrid)
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
				GridTraversal.printPlayerGrid(playerGrid);
				
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
