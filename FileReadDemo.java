import java.io.FileReader;

public class FileReadDemo
{
     public static void main(String[] args)
     {
          try
          {
               File source = new File("openMe.txt");
               FileReader read = new FileReader(source);
          }
          catch(IOException e)
          {
          }
     }
}
