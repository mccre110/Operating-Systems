import java.util.*; 
public class CheckerThread extends Thread
{
	int iUpper, iLower, jUpper, jLower, mode;
	int[] goodValues; 
	int bad = -1;
	int checkboard[][] = new int[9][9];;
	Board bd;

	public CheckerThread(Board bd, int mode)
	{
		this.bd = bd;
		this.mode = mode;
		for (int i=0;i<9;i++) 
				for (int j=0;j<9;j++) 
					checkboard[i][j] = 0;
	}
	public void run()
	{
		if (mode==1)
			modeOnerun();
		else if(mode==2)
			modeTworun();
		else if (mode ==3)
		{
			check(0,3,0,3);
			check(3,6,0,3);
			check(6,9,0,3);
			check(0,3,3,6);
			check(3,6,3,6);
			check(6,9,3,6);
			check(0,3,6,9);
			check(3,6,6,9);
			check(6,9,6,9);
		}
	}
	public void modeOnerun()
	{
		iUpper =9; iLower =0; jUpper=9; jLower=0;
		for (int i=iLower;i<iUpper;i++)
		{
			goodValues = new int[]{1,2,3,4,5,6,7,8,9}; 
			for (int j=jLower;j<jUpper;j++) 
			{
				if ((goodValues[bd.board[i][j]-1])!=bad)
					goodValues[bd.board[i][j]-1]=bad;
				else if(goodValues[bd.board[i][j]-1]==bad)
				{
					checkboard[i][j] = getValues(goodValues);
					for(int k = 0; k<iUpper; k++)
						if (bd.board[i][j]==bd.board[i][k])
							checkboard[i][k] = getValues(goodValues);
				}
			}
		}
	}
	public void modeTworun()
	{
		iUpper =9; iLower =0; jUpper=9; jLower=0;
		for (int i=iLower;i<iUpper;i++)
		{
			goodValues = new int[]{1,2,3,4,5,6,7,8,9}; 
			for (int j=jLower;j<jUpper;j++) 
			{
				if ((goodValues[bd.board[j][i]-1])!=bad)
					goodValues[bd.board[j][i]-1]=bad;
				else if(goodValues[bd.board[j][i]-1]==bad)
				{
					checkboard[j][i] = getValues(goodValues);
					for(int k = 0; k<9; k++)
						if (bd.board[j][i]==bd.board[k][i])
							checkboard[j][i] = getValues(goodValues);
				}
			}
		}
	}
	public void check(int iLower, int iUpper, int jLower, int jUpper)
	{
		goodValues = new int[]{1,2,3,4,5,6,7,8,9};
		for (int i=iLower;i<iUpper;i++)
			for (int j=jLower;j<jUpper;j++) 
			{
				if ((goodValues[bd.board[i][j]-1])!=bad)
					goodValues[bd.board[i][j]-1]=bad;
				else if(goodValues[bd.board[i][j]-1]==bad)
				{
					checkboard[i][j] = getValues(goodValues);
					for(int k = 0; k<iUpper; k++)
						for (int p=0;p<jUpper;p++) 
						{
							if (bd.board[i][j]==bd.board[p][k])
								checkboard[i][j] = getValues(goodValues);
						}
						
				}
			}	
	}
	public int[][] getBoard()
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
		System.out.println("");	
	}
	public int getValues(int[] arr)
	{
		for (int i=0;i<9;i++) 
		{
			if (goodValues[i]!=bad) 
			{
				return goodValues[i];
			}	
		}
		return 0;
	}
}