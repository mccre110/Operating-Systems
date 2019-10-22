import java.util.*;
import java.io.*;

public class Board
{
	int board[][];

	public Board(String fileName)
	{
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