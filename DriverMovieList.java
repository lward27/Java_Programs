public class DriverMovieList
{
     public static void main(String[] args)
     {
          MovieList m = new MovieList();
          m.add("Casablanca");
          m.add("Pink Flamingoes");
          m.add("200 Motels");
          System.out.println(m);
          System.out.println("There are " + m.size() + " movies on your list");
          Stupid(m);
          System.out.println(m);
          oblivion(m);
          System.out.println(m);
     }
     public static void Stupid(MovieList ml)
     {
          ml.add("Barney the Purple Dinosaur");
     }
     public static void oblivion(MovieList ml)
     {
          ml = new MovieList();
     }
}
