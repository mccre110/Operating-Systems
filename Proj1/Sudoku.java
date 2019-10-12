import java.util.Scanner;
import java.util.*;
public class Sudoku
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		// String file;
		// file = input.next();
		System.out.println("Enter board filename:");
		Board bd = new Board(input.next());
		bd.printBoard();
		CheckerThread rows = new CheckerThread(0,9,0,9,bd);
		rows.start();
		try
		{
			rows.join();
		}
		catch(Exception e)
		{

		}

		boolean[][] penis = rows.getBoard();
		System.out.println(Arrays.deepToString(penis));
		//bool rows.getBoard
	}
}