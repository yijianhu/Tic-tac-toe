import java.util.Stack;

public class game {
	private int[][] board;
	private Stack<Integer> steps;
	private boolean oddRound;
	/*    0 0 0		player 1 use 1
	 *    0 0 0 	player 2 use 2
	 *    0 0 0
	 */
	game()
	{
		board = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
		oddRound=true;
		steps=new Stack<Integer>();
	}
	
	/*	return code : 	0 	No winner
	 * 					1 	player 1 win
	 * 					2 	player 2 win
	 * 					-1	Invalid step
	 */
	public int set(int x, int y)
	{
		if(x<3 && y<3 && x>=0 && y>=0)
		{
			if(board[x][y]==0)
			{
				if(oddRound)
					board[x][y]=1;
				else
					board[x][y]=2;
				steps.push(x*10+y);
				if(isWin())
				{
					if(oddRound)
						return 1;
					else
						return 2;
				}
				oddRound=!oddRound;
				return 0;
			}
		}
		return -1;
	}
	
	public int[][] getBoard()
	{
		return board;
	}
	
	private boolean isWin()
	{
		//check rows and cols
		for(int x=0;x<3;x++)
		{
			int mulRow, mulCol;
			mulRow=0;
			mulCol=0;
			for(int y=0;y<3;y++)
			{
				mulRow*=board[y][x];
				mulCol*=board[x][y];
			}
			if(mulRow==1 || mulCol==8 || mulRow==8 || mulCol==1)
				return true;
		}
		
		//check diagonal
		if(board[1][1]*board[0][0]*board[2][2]==1 ||
				board[1][1]*board[0][0]*board[2][2]==8 ||
				board[1][1]*board[0][2]*board[2][0]==8 ||
				board[1][1]*board[0][2]*board[2][0]==1
				)
			return true;
		return false;
	}

}
