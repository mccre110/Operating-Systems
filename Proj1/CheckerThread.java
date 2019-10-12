import java.util.*; 
public class CheckerThread extends Thread
{
	int iUpper, iLower, jUpper, jLower;
	int[] goodValues; 
	int bad = -1;
	boolean checkboard[][] = new boolean[9][9];;
	Board bd;

	public CheckerThread(int iLower, int iUpper, int jLower, int jUpper, Board bd)
	{
		this.iUpper = iUpper;
		this.iLower = iLower;
		this.jUpper = jUpper;
		this.jLower = jLower;
		this.bd = bd;
		
		for (int i=0;i<9;i++) 
				for (int j=0;j<9;j++) 
					checkboard[i][j] = true;
		//this.goodValues = new int[]{1,2,3,4,5,6,7,8,9};
	}
	public void run()
	{
		for (int i=iLower;i<iUpper;i++)
		{
			goodValues = new int[]{1,2,3,4,5,6,7,8,9}; 
				for (int j=jLower;j<jUpper;j++) 
				{
					if ((goodValues[bd.board[i][j]-1])!=bad)
						goodValues[bd.board[i][j]-1]=bad;
						//continue;
					else if(goodValues[bd.board[i][j]-1]==bad)
					{
						checkboard[i][j] = false;
						for(int k = 0; k<9; k++)
						{
							if (bd.board[i][j]==bd.board[i][k])
							{
								checkboard[i][k] = false;
							}
						}
					}
				}
				System.out.println(Arrays.toString(goodValues));
		}
		//printCheckboard();
	}
	public boolean[][] getBoard()
	{
		return checkboard;
	}

	public void printCheckboard()
	{
		for (int i=0;i<9;i++) 
			{
				for (int j=0;j<9;j++) 
					System.out.print(checkboard[i][j]+"|");
				System.out.println("");
			}
	}
}