import java.util.*; 
public class CheckerThread extends Thread
{
	int iUpper, iLower, jUpper, jLower;
	int[] goodValues; 
	int bad = -1;
	Board bd;

	public CheckerThread(int iLower, int iUpper, int jLower, int jUpper, Board bd)
	{
		this.iUpper = iUpper;
		this.iLower = iLower;
		this.jUpper = jUpper;
		this.jLower = jLower;
		this.bd = bd;
		this.goodValues = new int[]{1,2,3,4,5,6,7,8,9};
	}
	public void run()
	{
		for (int i=iLower;i<iUpper;i++) 
				for (int j=jLower;j<jUpper;j++) 
					{
						if ((goodValues[bd.board[i][j]-1])!=bad)
							goodValues[bd.board[i][j]-1]=bad;
							//continue;
						else if(goodValues[bd.board[i][j]-1]==bad)
							bd.checkboard[i][j] = false;
					}

	}
	public Board getBoard()
	{
		return bd;
	}
}