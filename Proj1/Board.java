import java.util.*;
import java.io.*;

public class Board
{
	int board[][];
	boolean checkboard[][];


	public Board(String fileName)
	{
		checkboard = new boolean[9][9];
		for (int i=0;i<9;i++) 
				for (int j=0;j<9;j++) 
					checkboard[i][j] = true;

		board = new int[9][9];
		readIn(fileName);
	}
	public void printBoard()
	{
		for (int i=0;i<9;i++) 
			{
				for (int j=0;j<9;j++) 
					System.out.print("|"+board[i][j]+"|");
				System.out.println("");
			}
	}
	public void printCheckboard()
	{
		for (int i=0;i<9;i++) 
			{
				for (int j=0;j<9;j++) 
					System.out.print("|"+checkboard[i][j]+"|");
				System.out.println("");
			}
	}
	public void readIn(String fileName)
	{
		String row;
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(fileName));
			for (int i=0;i<9;i++) 
			{
				row = read.readLine();
				String[] data = row.split(",");
				for (int j=0;j<9;j++) 
					board[i][j] = Integer.parseInt(data[j]);
			}
		}
		catch(Exception e)
		{
			System.out.println("Read in failed");
		}

	}
}