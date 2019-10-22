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
		catch(Exception e)	{		}
		rows.printCheckboard();
		col.printCheckboard();
		sub.printCheckboard();

		int[][] one = rows.getBoard();
		int[][] two = col.getBoard();
		int[][] three =sub.getBoard();

		boolean cor = true;
		for (int i=0;i<9;i++) 
		{
			for (int j=0;j<9;j++) 
			{
				if (one[i][j]==two[i][j] && one[i][j] !=0)
				{
					System.out.println("Fucked");
					cor = false;
				}
				
				else if(one[i][j]==three[i][j]&& one[i][j] !=0)
				{
					System.out.println("Fucked");
					cor = false;
				}

				else if (two[i][j]==three[i][j]&& two[i][j] !=0) 
				{
					System.out.println("Fucked");
					cor = false;
				}
			}
		}
		if (cor)
		{
			System.out.println("Baustiofifiifiu board");
		}

		// System.out.println(Arrays.deepToString(one));
		// System.out.println(Arrays.deepToString(two));
		// System.out.println(Arrays.deepToString(three));
	}
}