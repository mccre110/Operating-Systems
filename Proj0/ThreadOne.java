public class ThreadOne extends Thread
{
	public void run() 
    { 
        try
        {
        	if (this.getName().equals("Polo")) 
        		this.setName(this.getName()+"\n");
            for (int i=0;i<10 ;i++) 
            {
                System.out.println (this.getName());
                this.sleep(1000);
            }
        } 
        catch (Exception e){
            System.out.println ("Exeption Thrown"); 
        }
    } 

}