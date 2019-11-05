import java.util.concurrent.Semaphore; ; 

class Sema 
{ 
    public static void main(String args[]) throws InterruptedException  
    {
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);

          
        MyThread f = new MyThread(sem1, sem2, "Fred"); 
        MyThread w = new MyThread(sem1, sem2,"Wilma"); 
          
        f.start(); 
        w.start(); 
           
        f.join(); 
        w.join(); 
          
    } 
} 