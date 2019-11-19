public class Scheduler extends Thread
{
	private MyThread one;
	private MyThread two;
	private MyThread three;
	private MyThread four;
	private int per;
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
			// one.start();
			// two.start();
			// three.start();
			// four.start();
			// one.curr.acquire();
			// two.curr.acquire();
			// three.curr.acquire();
			// four.curr.acquire();
			int time = 0;
			for (int i = 0;i<(per*1);i++) 
			{
				one.start();
				two.start();
				three.start();
				four.start();

				try
				{
					sch(time);
					time++;
					sleep(10);
				}
				catch(Exception e){}


			}

			one.join();
			two.join();
			three.join();
			four.join();
			System.out.println(one.count);
			System.out.println(two.count);
			System.out.println(three.count);
			System.out.println(four.count);
		}
		catch (Exception e){}

		
	}
	public void sch(int time)
	{
		// if (one.time==0)
		// {
		// 	one.time = time;
		// 	one.start();
		// 	//return;
		// }
		// try
		// {
		// 	if (time<(one.per+one.time))
		// 	{
		// 		one.time = time;
		// 		one.curr.release();
		// 		return;
		// 	}
		// 	else if ((time>=(one.per+one.time))&& time<(two.per+two.time) )
		// 	{
		// 		two.time = time;
		// 		//one.curr.acquire();
		// 		two.curr.release();
		// 		return;
		// 	}
		// 	else if ( time<(three.per+three.time) )
		// 	{
		// 		three.time = time;
		// 		two.curr.acquire();
		// 		three.curr.release();
		// 		return;
		// 	}
		// 	else if ((time>=(three.per+three.time))&& time<(four.per+four.time) )
		// 	{
		// 		four.time = time;
		// 		three.curr.acquire();
		// 		four.curr.release();
		// 		return;
		// 	}

			if (time%one.per==0) 
			{
				//one.time = time;
				one.isSch = true;
				one.curr.release();
				//System.out.println("1");
			}
			if(time%two.per==0)
			{
				// two.time = time;
				two.isSch = true;
				two.curr.release();
				//System.out.println("2");
			}
			if(time%three.per==0)
			{
				// three.time = time;
				three.isSch = true;
				three.curr.release();
				//System.out.println("3");
			}
			if(time%four.per==0)
			{
				// four.time = time;
				four.isSch = true;
				four.curr.release();
				//System.out.println("4");
			}
			one.time = time;
			two.time = time;
			three.time = time;
			four.time = time;
		// }
		// catch(Exception e){}

		// else if ((time>=(one.per+one.time))&&(time<(two.per+two.time)))
		// {
		// 	try
		// 	{
		// 		System.out.println("waiting");
		// 		one.wait();
		// 		two.notify();
		// 	}
		// 	catch (Exception e){}
		// 	//return;
		// }
		// else if (two.greaterThan(three) && two.greaterThan(four) && (time>=(two.per+two.time)))
		// {
		// 	try
		// 	{
		// 		two.wait();
		// 		three.notify();
		// 	}
		// 	catch (Exception e){}
		// 	return;
		//}
	}
}