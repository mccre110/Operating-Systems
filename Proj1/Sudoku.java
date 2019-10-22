import java.util.Scanner;
import java.util.*;
public class Sudoku
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter board filename:");
		Board bd = new Board(input.next());
		//bd.printBoard();

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
		// rows.printCheckboard();
		// col.printCheckboard();
		// sub.printCheckboard();

		boolean cor = true;
		for (int i=0;i<9;i++) 
		{
			for (int j=0;j<9;j++) 
			{
				for (int k=1;k<10;k++) 
				{
					if (one[i][j][k]==two[i][j][k] && one[i][j][k]==three[i][j][k] &&one[i][j][k]!=0)
					{
						System.out.println("Row: "+(i+1)+" Colum: "+(j+1)+" should be : "+one[i][j][k]);
						cor = false;
					}
				}
			}
		}
		if (cor)
			System.out.println("Good board");
	}
}