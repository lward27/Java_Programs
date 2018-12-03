/**
 * DrawEggs prints out the shapes shown in Reges and Stepp 
 * Exercise # 7 on pa. 48
 * @author Lucas Ward
 */
public class DrawEggs 
{

	/**
	* The main method starts the program and prints 
	* the shapes to the console window
	*/
	public static void main(String [] args) 
	{
		drawTopEgg();
		drawBottomEgg();
		System.out.println();
		drawLine();
		System.out.println();
		drawTopEgg();
		drawBottomEgg();
		System.out.println();
		drawLine();
		drawBottomEgg();
		drawTopEgg();
		drawLine();
		drawBottomEgg();
	}

	public static void drawTopEgg()
	{
		System.out.println("  _______");
		System.out.println(" /       \\");
		System.out.println("/         \\");
	}

	public static void drawBottomEgg()
	{
		System.out.println("\\         /");
		System.out.println(" \\_______/");
	}

	public static void drawLine()
	{
		System.out.println("-\"-'-\"-'-\"-");
	}
}
