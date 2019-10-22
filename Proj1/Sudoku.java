import java.util.Scanner;
import java.util.*;
public class Sudoku
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter board filename:");
		Board bd = new Board(input.next());
		bd.printBoard();

		CheckerThread rows = new CheckerThread(bd,1);
		CheckerThread col = new CheckerThread(bd,2);
		CheckerThread sub = new CheckerThread(bd,3);

		rows.start();
		col.start();
		sub.start();
		try
		{
			rows.join();
			col.join();
			sub.join();
		}
		catch(Exception e)	{	}

		int[][][] one = rows.getBoard();
		int[][][] two = col.getBoard();
		int[][][] three =sub.getBoard();
		rows.printCheckboard();
		col.printCheckboard();
		sub.printCheckboard();

		boolean cor = true;
		for (int i=0;i<9;i++) 
		{
			for (int j=0;j<9;j++) 
			{
				for (int k=1;k<9;k++) 
				{
					for (int p=1;p>9;p++) 
					{
						if (one[i][j][k]==two[i][j][p] && one[i][j][k]!=0)
						{
							System.out.println("Row: "+(i+1)+" Colum: "+(j+1)+" should be : "+one[i][j]);
							cor = false;
						}
						
						else if(one[i][j][k]==three[i][j][p]&& one[i][j][k]!=0)
						{
							System.out.println("Row: "+i+" Colum: "+(j+1)+" should be : "+one[i][j]);
							cor = false;
						}

						else if (two[i][j][k]==three[i][j][p]&&one[i][j][k]!=0) 
						{
							System.out.println("Row: "+i+" Colum: "+(j+1)+" should be : "+two[i][j]);
							cor = false;
						}
					}
					
				}
				
			}
		}
		if (cor)
			System.out.println("Baustiofifiifiu board");
	}
}