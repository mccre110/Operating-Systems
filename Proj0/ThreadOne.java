public class ThreadOne extends Thread
{
	public void run() 
    { 
        try
        {
        	if (this.getName().equals("Polo   ")) 
        		this.setName(this.getName()+"\n");
            for (int i=0;i<100 ;i++) 
            {
                System.out.print(this.getName());
                this.sleep(1000);
            }
        } 
        catch (Exception e){
            System.out.println ("Exeption Thrown"); 
        }
    } 

}