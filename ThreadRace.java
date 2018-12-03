/**
 * This class creates three threads and has them each print a different
 * three letter message 10,000 times.  
 * @author Lucas Ward
 * @version 1.0
 */
public class ThreadRace {
  /**
   * This class creates a version of runnable 
   * called run() that prints a three leter
   * message ABC. 
   */ 
  static class ABCRunnable implements Runnable { // From example in HelloThreads.
    public void run() {
      System.out.print("A");
      System.out.print("B");
      System.out.print("C");
    }
  }
  /**
   * Same as ABCRunnable but prints the message
   * DEF.
   */   
  static class DEFRunnable implements Runnable {
    public void run() {
      System.out.print("D");
      System.out.print("E");
      System.out.print("F");
    }
  }
  /**
   * Same as ABCRunnable and DEFRunnable but prints
   * the message GHI.
   */ 
  static class GHIRunnable implements Runnable {
    public void run() {
      System.out.print("G");
      System.out.print("H");
      System.out.print("I");
    }
  }
  //These three Classes, ABC, DEF, and GHIRunnable
  //are function for the thread thread to run.

  /**
   * Creates instances of classes and initializes them
   * to run the three different message runnables.
   * @param args is a String array containg arugments
   * from the standard in at program execution.
   */ 
  public static void main(String[] args) {
    for(int i = 0; i < 10000; i++) { //Run Three message circle
				     //10,000 times
      Thread abcThread = new Thread(new ABCRunnable()); // Also in 
							// HelloThreads.c
      abcThread.start();
      Thread defThread = new Thread(new DEFRunnable());
      defThread.start();
      Thread ghiThread = new Thread(new GHIRunnable());
      ghiThread.start();

      try {
        abcThread.join();
      } catch (InterruptedException e) {
        System.out.println("Join Incomplete: Interrupted");
      }
      try {
        defThread.join();
      } catch (InterruptedException e) {
        System.out.println("Join Incomplete: Interrupted");
      }
      try {
        ghiThread.join();
      } catch (InterruptedException e) {
        System.out.println("Join Incomplete: Interrupted");
      }
      System.out.println(); // New line for next message.
    }
  }
}











