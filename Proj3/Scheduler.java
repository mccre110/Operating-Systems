public class Scheduler extends Thread
{
	private int per;
	private MyThread[] threads;

	public Scheduler(MyThread one, MyThread two, MyThread three, MyThread four, int per)
	{
		this.per = per;
		threads = new MyThread[]{one,two,three,four};
	}

	@Override
	public void run()
	{
		try
		{
			for (MyThread all:threads) 
			{
				all.sema.acquire();
				all.start();
			}
			int time =0;
			for (int i = 0;i<160;i++) 
			{
				sch(i);
				sleep(10);
				time++;
			}
			for (MyThread all:threads) 
			{
				all.quit = true;
				all.sema.release();
				all.join();
			}
			print();
		}
		catch (Exception e) {System.out.println(e);}		
	}
	public void sch(int time)
	{
		for (MyThread x:threads)
			if(time%x.per==0)
			{
				if (!x.finished)
					x.overrun++;
				else
					x.sema.release();
			}
	}
	public void print()
	{
		for (MyThread x:threads)
			System.out.println(x.getName()+
				" - Ran:"+x.count+" times | Overran : " +x.overrun);
	}
}