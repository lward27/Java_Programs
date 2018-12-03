import java.util.ArrayList;

public class MovieList
{
     private ArrayList<String> movies;
     
     public MovieList()
     {
          movies = new ArrayList<String>();
     }
     //Mutator method
     public void add(String newMovie)
     {
          movies.add(newMovie);
     }
     public int size()
     {
          return movies.size();
     }
     public boolean remove(String oustedMovie)
     {
          return movies.remove(oustedMovie);
     }
     public String toString()
     {
          String out = "";
          for(String k: movies)
          {
               out += k + "\n";
          }
          return out;
     }
}
