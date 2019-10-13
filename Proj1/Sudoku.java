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

		boolean[][] one = rows.getBoard();
		boolean[][] two = col.getBoard();
		boolean[][] three =sub.getBoard();
		System.out.println(Arrays.deepToString(one));
		System.out.println(Arrays.deepToString(two));
		System.out.println(Arrays.deepToString(three));
	}
}