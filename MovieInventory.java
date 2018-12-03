/**
 * This class keeps an inventory of all movies
 * @author Lucas Ward
 * @version 1.0
 */
public class MovieInventory {
	
	private static final int INVENTORY_SIZE = 10;
	private static final Exception IllegalArgumentException = null;
	private Movie [] movies;
	
	
	public MovieInventory() {
		movies = new Movie[INVENTORY_SIZE];
	}
	
	public static void main(String[] args) {
		System.out.println("Start MovieInventory");
	}
	
	/**
	 * Adds a movie to the list if it doesn't all ready exist, the list isn't more than ten items long
	 * or the releaseYear is before 1880.
	 * @param title
	 * @param releaseYear
	 * @param genre
	 * @param rating
	 * @return
	 * @throws Exception
	 */
	public boolean addMovie(String title, int releaseYear, String genre, String rating) throws Exception  {
		if(releaseYear < 1880) {
			throw IllegalArgumentException;
		}
		for(int i = 0; i < movies.length; i++)
        {
				if(movies[i] == null)
	            {	
	                    movies[i] = new Movie(title, releaseYear, genre, rating);
	                    System.out.println("movie added");
	                    return true;
	            }
				
				if(movies[i] != null) {
						if(movies[i].getTitle().equals(title) && movies[i].getReleaseYear()==releaseYear && 
								movies[i].getGenre().equals(genre) && movies[i].getRating().equals(rating)) {
							System.out.println("movie allready exists");
							return false;
						}
				}
				
				
        }
		System.out.println("no more room in the list");
        return false;
        

	}

}
