import java.io.*;
import java.util.*;

/**
 * This program will read a file and calculate the average, count, sum, min, 
 * and max values of the integers contained in input file.
 * @author Lydia Peedin
 * @author Danielle DelPonte
 * @author Zach Poole
 * @version 1.0
 */
public class ProcessFile {

        /**
         * This method is the main method that calls the userInterface method.
         */
        public static void main(String[] args) throws FileNotFoundException {
                userInterface();
                }
        
        /**
         * This method is the userInterface method that calls accepts user 
         * input and calls the calculateFile method
         */
        public static void userInterface() throws FileNotFoundException {
                Scanner in = new Scanner(System.in);
                //Prompts the user for a file
                System.out.println("What is the name of your file?");
                
                String q = in.next();
                File f = new File(q);
                        
                        //Checks to see if the file exists
                        while(!f.exists()) {
                                System.out.println("File does not exist, please try again");
                        }
                        Scanner input = new Scanner(f);
                        //Sends the file to calculateFile method
                        calculateFile(input);
                }
        /**
         * This method is the calculateFile method that carries out all the 
         * calculations for count, sum, max, min, and average. 
         * @param input this is a scanner that accepts the file from the user 
         */
        public static void calculateFile(Scanner input) throws FileNotFoundException {
                                
                int sum = 0;
                int count = 0;
                int d = 0;
                int minimum = Integer.MAX_VALUE;
                int maximum = Integer.MIN_VALUE;
                
                while (input.hasNext()) {
                        if (input.hasNextInt()) {
                                d = input.nextInt();
                                sum += d;
                                count++;
                                minimum = Math.min(minimum,d);
                                maximum = Math.max(maximum,d);                                
                        }
                        else {
                                input.next();        
                        }                
                }
                double average = sum / count;
                System.out.println("Average: " + average);
                
                System.out.println("Max: " + maximum);

                System.out.println("Min: " + minimum);
                
                int total = sum;
                System.out.println("Sum: " + total);
                
                int number = count;
                System.out.println("Number of Integers: " + count);        
        }
}
