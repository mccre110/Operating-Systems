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
		tOne.setPriority(4);
		MyThread tTwo = new MyThread("Two", 2, 200, two, three);
		tTwo.setPriority(3);
		MyThread tThree = new MyThread("Three", 4, 400, three, four);
		tThree.setPriority(2);
		MyThread tFour = new MyThread("Four", 16, 1600, four, one);
		tFour.setPriority(1);
		Scheduler rms = new Scheduler(tOne, tTwo, tThree, tFour, 16);
		rms.start();

		 try
		 {
		 	rms.join();
		 } catch(Exception e){}
		
		
	}
}
