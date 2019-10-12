public class MarcoPolo
{
	public static void main(String[] args) 
	{
		ThreadOne marco = new ThreadOne();
		ThreadOne polo = new ThreadOne();
		marco.setName("Marco    ");
		polo.setName("Polo   ");
		marco.start();
		polo.start();

		try
		{
			marco.join();
			polo.join();
			System.out.println("That's all folks"+"\n");
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
		}
		
	}
}
