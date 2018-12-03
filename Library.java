public class Library
{
	private Book[] books;
	private static final int SIZE = 10;

	public Library()
	{
		books = new Book[SIZE];
	}
	
	public boolean addBook(String title, String author, int pubYear)
	{
		for(int i = 0; i < books.length; i++)
		{
			if(books[i] == null)
			{
				books[i] = new Book(title, author, pubYear, i);
				return true;
			}
		}
		return false;
	}
}
