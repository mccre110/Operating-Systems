import java.util.concurrent.Semaphore;
public class MyThread extends Thread
{
	public int per;
	public int count =0;
	public int loops;
	public int time =0;
	public Semaphore curr;
    private double[][] myArr;
    public boolean finished = false;
    public int endtime;
    public boolean quit = false;
    public boolean running = false;
    public int overrun;

	public MyThread(String name, int per, int loops, Semaphore curr)
	{
		super(name);
		this.per = per;
		this.loops = loops;
		this.curr = curr;

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
				//System.out.println(this.getName());
				curr.acquire();
				// if (quit) {
				// 	break;
				// }
				running =true;
				count++;
				finished = false;
				for (int i=0; i<loops;i++) 
				{
					doWork();
					if (time>=endtime) 
					{
						running =false;
						break;
					}
				}
				running =false;
				if (time>=endtime) 
					continue;

				finished = true;

				//break;
			}
			catch(Exception e){System.out.println(e);}
		}
	}

	public void doWork()
	{
		double tot =1.00;
		for (int i =0;i<5;i++) 
		{
			for (int j =0;j<10;j++) 
			{
				myArr[j][i] *= myArr[j][i];
			}
			for (int j =0;j<10;j++) 
			{
				myArr[j][i] *= myArr[j][i+5];
			}
		}
	}
	public boolean greaterThan(MyThread t)
	{
		boolean check = false;
		if (this.getPriority()>t.getPriority()) 
		{
			check = true;
		}
		return check;
	}

}