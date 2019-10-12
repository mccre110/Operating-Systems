import java.util.Scanner;
public class Sudoku
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		// String file;
		// file = input.next();
		System.out.println("Enter board filename:");
		Board bd = new Board(input.next());
		bd.print();
		CheckerThread rows = new CheckerThread(0,bd)

		bool rows.getBoard
	}
}