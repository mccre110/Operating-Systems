import java.util.concurrent.Semaphore; 
public class Rms
{
	public static void main(String[] args) 
	{
		Semaphore one = new Semaphore(1);
		Semaphore two = new Semaphore(1);
		Semaphore three = new Semaphore(1);
		Semaphore four = new Semaphore(1);

		MyThread tOne = new MyThread("One", 1, 100, one, two);
		tOne.setPriority(9);
		MyThread tTwo = new MyThread("Two", 2, 2000, two, three);
		tTwo.setPriority(8);
		MyThread tThree = new MyThread("Three", 4, 400, three, four);
		tThree.setPriority(7);
		MyThread tFour = new MyThread("Four", 16, 1600, four, one);
		tFour.setPriority(6);
		Scheduler rms = new Scheduler(tOne, tTwo, tThree, tFour, 16);
		rms.setPriority(10);
		rms.start();

		 try
		 {
		 	rms.join();
		 	//rms.print();
		 } catch(Exception e){}
		
		
	}
}
