public class Scheduler extends Thread
{
	private int per;
	private MyThread[] threads;
	private MyThread current;
	public Scheduler(MyThread one, MyThread two, MyThread three, MyThread four, int per)
	{
		this.per = per;
		threads = new MyThread[]{one,two,three,four};
		current = one;
	}

	@Override
	public void run()
	{
		try
		{

			for (MyThread x:threads) 
			{
				x.curr.acquire();
				x.start();
			}

			int time = 0;

			for (int i = 0;i<(per*10);i++) 
			{
				current = sch(i, current);
				i = time;
				time++;
				sleep(10);
			}

			for (MyThread x:threads) 
			{
				x.quit = true;
				x.join();
			}

			print();
		}
		catch (Exception e) {System.out.println(e);}

		
	}
	public MyThread sch(int time, MyThread current)
	{

		for (MyThread x:threads)
		{
			if(time%x.per==0)
			{
				// if (!x.finished && time!=0) 
				// {
				// 	x.overrun++;
				// 	time = nextPer(time);
				// 	break;
				// }
				// else
				// {
				// 	if (!threads[0].running&&!threads[1].running&&!threads[2].running&&!threads[3].running) 
				// 	{
				// 		x.endtime = (time)+x.per;
				// 		x.curr.release();
				// 		break;
				// 	}
				// }

				if(time%x.per==0)
				{
					if (!x.finished && x.running) 
					{
						x.overrun++;
						time = nextPer(time);

						//x.curr.acquire();
						break;
					}
					else
					{
						if (!threads[0].running&&!threads[1].running&&!threads[2].running&&!threads[3].running&&!x.finished) 
						{
							x.endtime = (time)+x.per;
							x.curr.release();
							//System.out.println(time+x.getName());
							return x;
						}
						else if(x.greaterThan(current)&&!x.finished)
						{
							try
							{
								current.curr.acquire();
								x.curr.release();
								return x;
							}
							catch(Exception e){System.out.println(e);}
							
						}
						//return current;
						//System.out.println(time+"|"+threads[1].running);
					}
				}
			}
		}

		for (MyThread x:threads)
			x.time = time;
		return current;
	}
	public int nextPer(int current)
	{
		return current+(per-(current%per));
	}
	public void print()
	{
		for (MyThread x:threads)
			System.out.println(x.getName()+" - Ran :"+x.count+" | Overran : " +x.overrun);
	}
}