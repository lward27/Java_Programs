import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class FileDemo
{
     public static void main(String [] args)
     {               
          File stuff = new File("stuff.txt");
          try
          {
               FileWriter stuffWriter = new FileWriter(stuff);
               BufferedWriter putStuff = new BufferedWriter(stuffWriter);
               putStuff.write("Cowabunga");
               putStuff.close();
          }
          catch(IOException e)
          {
               System.err.println("File cannot be opened");
          }
          
     }
}
