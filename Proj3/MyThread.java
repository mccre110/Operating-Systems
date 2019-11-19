import java.util.concurrent.Semaphore;
public class MyThread extends Thread
{
	public int per;
	public int count =0;
	public int loops;
	public int prio;
	public int time =0;
	public Semaphore curr; 
    public Semaphore next;
    private double[][] myArr;
    public boolean isSch;

	public MyThread(String name, int per, int loops, Semaphore curr, Semaphore next)
	{
		super(name);
		isSch = false;
		prio = 1/per;
		this.per = per;		
		this.loops = loops;
		this.curr = curr;
		this.next = next;
		myArr= new double[10][10];
		for (int i=0;i>10;i++) 
		{
			for (int j=0;j<10;j++) 
			{
				myArr[i][j] = 1.00;
			}
		}
	}

	@Override
	public void run()
	{
		while(isSch && time<16)
		{
			try
			{
				curr.acquire();
				System.out.println(this.getName());
				for (int i=0; i<loops;i++) 
				{
					doWork();
					count++;
					//System.out.println(count);
					//sleep(10);
				}
				//time = -1;
				//next.release();
				//sleep(10);
				next.release();
				break;
			}
		
			catch(Exception e)
			{
				System.out.println("Something Bad Happened");
			}

		}
		
	}

	public void doWork()
	{
		double tot =1.00;
		for (int i =0;i<5;i++) 
		{
			for (int j =0;j<10;j++) 
			{
				tot *= myArr[j][i];
			}
			for (int j =0;j<10;j++) 
			{
				tot *= myArr[j][i+5];
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