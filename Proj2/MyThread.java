import java.util.concurrent.Semaphore; 

public class MyThread extends Thread 
{ 
    Semaphore sem1; 
    Semaphore sem2; 
    String threadName; 
    public MyThread(Semaphore sem1,Semaphore sem2, String threadName)  
    { 
        super(threadName); 
        this.sem1 = sem1; 
        this.sem2 = sem2;  
        this.threadName = threadName;
    } 
  
    public void run() { 
           
        if(this.getName().equals("Fred")) 
        { 
            while(Shared.fredCount<10)
            {
                try 
                { 
                   sem1.acquire(); 
                   
                    while(Shared.wilmDis>1 &&Shared.fredCount<10)
                    {
                        if (Shared.fredDis==1){
                            Shared.fredCount++;
                            System.out.println();
                            System.out.println("Count: "+Shared.fredCount);
                        } 
                            //Shared.fredCount++;

                        Shared.rate=1;
                        Shared.fredDis +=Shared.rate;
                        Shared.wilmDis-=Shared.rate;
                        //System.out.println("Count: "+Shared.fredCount);
                        System.out.println("Fred: "+ Shared.fredDis+" | "+ "Wilma: "+ Shared.wilmDis);
                        Thread.sleep(1000);
                    }
                    sem2.release();
                     
                } 
                catch (InterruptedException exc) 
                { 
                        System.out.println(exc); 
                }
            } 
        } 
          
        else if(this.getName().equals("Wilma"))
        { 
            while(Shared.fredCount<10)
            {
                try
                {
                sem2.acquire(); 
                    while(Shared.fredDis>1&&Shared.fredCount<10)
                    {
                        Shared.rate=1.5;
                        Shared.fredDis -=Shared.rate;
                        Shared.wilmDis+=Shared.rate;
                        //System.out.println("Count: "+Shared.fredCount);
                        System.out.println("Fred: "+ Shared.fredDis+" | "+ "Wilma: "+ Shared.wilmDis);
                        Thread.sleep(1000); 
                    }
                sem1.release(); 
                    
                } 
                catch (InterruptedException exc) 
                { 
                        System.out.println(exc); 
                } 
            
            }
        } 
    } 
} 