public class ForLooper
{
	public static final int NUMBER = 10;
	public static void main(String[] args) throws InterruptedException
	{
		for(int i=0; i<NUMBER; i++)
		{
			System.out.print(i);
			Thread.sleep(1000);
			/*Thread thisThread = Thread.currentThread();
         			try
             			{
             				thisThread.sleep(1000);
         			}
         			catch (Throwable t)
             			{
             				throw new OutOfMemoryError("An Error has occured");
         			}*/
		}
	System.out.println();
	}
}
