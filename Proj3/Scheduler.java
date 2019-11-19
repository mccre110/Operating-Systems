public class Scheduler extends Thread
{
	private MyThread one;
	private MyThread two;
	private MyThread three;
	private MyThread four;
	private int per;
	private int oneRun;
	private int twoRun;
	private int threeRun;
	private int fourRun;
	public Scheduler(MyThread one, MyThread two, MyThread three, MyThread four, int per)
	{
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.per = per;
	}

	@Override
	public void run()
	{
		try
		{
			// one.curr.acquire();
			// two.curr.acquire();
			// three.curr.acquire();
			// four.curr.acquire();
			one.start();
			two.start();
			three.start();
			four.start();

			int time = 0;
			for (int i = 0;i<(per*10);i++) 
			{
				sch(i);
				i = time;
				time++;
				sleep(10);
			}

			one.join();
			two.join();
			three.join();
			four.join();
			print();
			
		}
		catch (Exception e){System.out.println(e);}

		
	}
	public void sch(int time)
	{
		if (time%one.per==0) 
		{
			if (!one.finished) 
			{
				oneRun++;
				time = nextPer(time);
			}
			else
			{
				//System.out.println(time);
				one.endtime = (time%per)+one.per;
				one.curr.release();
			}
			
			//one.isSch = true;
			//System.out.println("1");
		}
		if(time%two.per==0 && one.finished)
		{
			if (!two.finished) 
			{
				twoRun++;
				time = nextPer(time);
			}
			else
			{
				two.endtime = (time%per)+two.per;
				two.curr.release();
			}
			
			// two.time = time;
			//two.isSch = true;
			
			//System.out.println("2");
		}
		if(time%three.per==0&& two.finished)
		{
			if (!three.finished) 
			{
				threeRun++;
				time = nextPer(time);
			}
			else
			{
				three.endtime = (time%per)+three.per;
				three.curr.release();	
			}
			
			// three.time = time;
			//three.isSch = true;
			
			//System.out.println("3");
		}
		if(time%four.per==0&& three.finished)
		{
			if (!four.finished) 
			{
				fourRun++;
				time = nextPer(time);
			}
			else
			{
				//System.out.println(time);
				four.endtime = (time%per)+four.per;
				four.curr.release();
			}
			
			// four.time = time;
			//four.isSch = true;
			
			//System.out.println("4");
		}
		one.time = time%per;
		two.time = time%per;
		three.time = time%per;
		four.time = time%per;
	}
	public int nextPer(int current)
	{
		return current+(per-(current%per));
	}
	public void print()
	{
			System.out.println(one.count);
			System.out.println(two.count);
			System.out.println(three.count);
			System.out.println(four.count);

			System.out.println(oneRun);
			System.out.println(twoRun);
			System.out.println(threeRun);
			System.out.println(fourRun);
	}
}