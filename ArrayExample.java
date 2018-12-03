import java.util.Arrays;
import java.util.ArrayList;
public class ArrayExample
{
     public static void main(String[] args)
     {
          String [] foo = null;  //null is the graveyard state.
          System.out.println(foo);
          foo = new String[5];
          System.out.println(foo[0]);  //the java ovipositor point all entries at null
          foo[0] = "Wam Soo";
          foo[1] = "Cill Wondon";
          foo[2] = "Berry Joarman";
          foo[3] = "Milford Cubicle";
          foo[4] = "Varth Dader";
          System.out.println(Arrays.toString(foo));
          for(int k = 0; k < foo.length; k++)
          {
               System.out.print(foo[k] + " ");
          }
          int index = 0;
          while(index < foo.length)
          {
               System.out.print(foo[index] + " ");
               index++;
          }
          //Collections forloopication
          for(String k : foo)
          {
               System.out.print(k + " ");
          }
          String[] months = {"January", "February", "March"};
          ArrayList<String> monaten = new ArrayList<String>();
          monaten.add("Januar");
          monaten.add("Febuar");
          monaten.add("Maerz");
          System.out.println(monaten);
          System.out.println(months);
          monaten.add("Blau Elch");
          System.out.println(monaten);
          monaten.remove("Blau Elch"); //monaten.remove(3) works
          System.out.println(monaten);
          System.out.println(monaten.indexOf("Febuar"));
          System.out.println(months.length);
          System.out.println(monaten.size());
          System.out.println(monaten.get(1));
          monaten.add("Wienerschnitzel");
          System.out.println(monaten);
          monaten.set(3, "April");
          System.out.println(monaten);
          System.out.println(monaten.contains("Ferrari"));
          System.out.println(monaten.indexOf("Ferrari") >= 0);
     }
     
}
