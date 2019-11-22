import java.util.concurrent.Semaphore;
public class MyThread extends Thread
{
	public int per;
	public int count =0;
	public int loops;
	public Semaphore sema;
    private double[][] myArr;
    public boolean finished = true;
    public boolean quit = false;
    public int overrun;

	public MyThread(String name, int per, int loops, Semaphore sema)
	{
		super(name);
		this.per = per;
		this.loops = loops;
		this.sema = sema;

		myArr= new double[10][10];
		for (int i=0;i>10;i++) 
			for (int j=0;j<10;j++) 
				myArr[i][j] = 1.000;
	}

	@Override
	public void run()
	{
		while(!quit)
		{
			try
			{
				sema.acquire();
				finished = false;
				if (quit)
					break;
				else
					count++;
				for (int i=0; i<loops;i++) 
					doWork();
				finished = true;
			}
			catch(Exception e){System.out.println(e);}
		}
	}

	public void doWork()
	{
		for (int i =0;i<5;i++) 
		{
			for (int j =0;j<10;j++) 
				myArr[j][i] *= myArr[j][i];
			for (int j =0;j<10;j++) 
				myArr[j][i] *= myArr[j][i+5];
		}
	}
}