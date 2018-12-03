import java.util.*;
public class RetrievalSystem
{
	public static void main(String[] args)
	{
		Book[] books = new Book[3];
		try
		{
			books[0] = new Book("Harry Potter", "J.K. Rowling", 2007, -45);
		} catch(InputMismatchException e) {
			System.out.println("book could not be created");
		}
		
		books[0] = new Book("Harry Potter", "J.K. Rowling", 2007, 45);
		
		books[1] = new Book("Flowers for Algernon", "Daniel Keyes", 1959, 44);
		
		books[2] = new Book("Harry Potter", "J.K. Rowling", 2007, 34);	
		System.out.println(books[0].getTitle() + " by " + books[0].getAuthor() + " published in: " + books[0].getPubYear());
		System.out.println(books[1].getTitle() + " by " + books[1].getAuthor() + " published in: " + books[1].getPubYear());

		if(books[0].checkOut("lmward3"))
		{
			System.out.println("Checked out to " + books[0].getCheckedOutTo());
		} else {
			System.out.println("Already checked out to: " + books[0].getCheckedOutTo());
		}

		if(books[1].checkOut("lrpeedin"))
		{
			System.out.println("Checked out to " + books[1].getCheckedOutTo());
		} else {
			System.out.println("Already checked out to: " + books[1].getCheckedOutTo());
		}
		
		if(books[0].checkOut("dadelpon"))
		{
			System.out.println("Checked out to " + books[0].getCheckedOutTo());
		} else {
			System.out.println("Already checked out to: " + books[0].getCheckedOutTo());
		}
		//System.out.println(books[0].getCheckedOutTo());
		//books[1].checkIn;
		//System.out.println(books[0].getCheckedOutTo);
		if(books[1].checkIn())
		{
			System.out.println(books[1].getTitle() + " by " + books[1].getAuthor() + " published in: " + books[1].getPubYear());
		} else {
			System.out.println("error");
		}

		books[0].equals(books[2]);
		
		Book b = new Book();
		System.out.println(b.toString());
		
		System.out.println(books[0].getTitle() + " is due " + books[0].getDueDate());
	}
}
