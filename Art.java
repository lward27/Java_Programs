/**
 * The Art class produces ascii art Roller Coasters,
 * this is my design.
 * @author Lucas Ward
 * @version 1.0
 */

public class Art
{
	/**
	 * The main method runs the methods in the program
	 */
	public static void main(String[] args)
	{
		drawStation();	
		drawLiftHill();
		drawSteepDrop();
		drawLoop();
		drawEntireHill();
		drawCorkScrew();
		drawLoop();
		drawEntireHill();
		drawStation();
	}
	
	/**
	 * The drawEntireHill method runts the methods
	 * steepIncline and SteepDrop in order to make
	 * a steep hill
	 */
	public static void drawEntireHill()
	{
		drawSteepIncline();
		drawSteepDrop();
	}
	
	/**
	 * The drawLiftHill method draws an ascii art roller coaster life hill
	 */
	public static void drawLiftHill()
	{
		System.out.println("||");
		System.out.println("\\\\");
		System.out.println(" \\\\");
		System.out.println("  \\\\");
		System.out.println("   \\\\");
		System.out.println("    \\\\");
		System.out.println("     \\\\");
		System.out.println("      \\\\");
		System.out.println("       \\\\");
		System.out.println("        \\\\");
		System.out.println("         \\\\");
		System.out.println("          \\\\");
		System.out.println("            )");
	}

	/**
         * The drawSteepDrop method draws an ascii art roller coaster drop
         */
	public static void drawSteepDrop()
	{
		System.out.println(" _________/");
		System.out.println("/     ");
		System.out.println("| ");
	}

	/**
         * The drawLoop method draws an ascii art roller coaster loop
         */
	public static void drawLoop()
	{ 
		System.out.println("\\    __");
		System.out.println(" \\  /   \\ ");
		System.out.println("  \\/     |");
		System.out.println("  /\\____/");
		System.out.println(" /");
		System.out.println("/ ");
		System.out.println("|");
	}

	/**
         * The drawSteepIncline method draws and ascii art roller
	 * coaster incline
         */
	public static void drawSteepIncline()
	{
		System.out.println("\\_________");
		System.out.println("          \\ ");
		System.out.println("           )");
	}

	/**
         * The drawCorkScrew method draws an ascii art rollercoaster
	 * cork screw
         */
	public static void drawCorkScrew()
	{
		System.out.println("\\_");
		System.out.println("/");
		System.out.println("|");
	}

	/**
         * The drawStation method draws an ascii art rollercoaster
	 * Station platform
         */
	public static void drawStation()
	{
		System.out.println("   ______");
		System.out.println("|\\|     S ");
		System.out.println("|\\|     C ");
		System.out.println("|\\|     R ");
		System.out.println("|\\|     E ");
		System.out.println("|\\|     A ");
		System.out.println("|\\|_____M");
	}
}
