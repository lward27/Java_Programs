import java.util.*;

/**
 * Template for library books for the Hunt
 * Library
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 */
public class Book {

   /** Title of the book */
   private String title;
   /** Author of the book */
   private String author;
   /** Book's publication year */
   private int pubYear;
   /** Unity ID of person who has book checked out */
   private String checkedOut;
   /** Book's location in the stacks */
   private int location;
   /** Book's due date */
   private DueDate dueDate;
   /** Standard length of checkout in days */
   private static final int CHECKOUT_LENGTH = 90;

   /**
    * Constructs a new Book object with the specified information
    * @param newTitle the title of the Book
    * @param newAuthor the author of the Book
    * @param newPubYear the publication year of the Book
    * @param newLocation the Book's location in the stacks
    */
   public Book(String newTitle, String newAuthor, int newPubYear, int newLocation) {
      title = newTitle;
      author = newAuthor;
      pubYear = newPubYear;
      setLocation(newLocation);
      checkedOut = ""; //initially not checked out
      dueDate = null; //can only have a DueDate if Book is checkedOut
   }

   public Book() {
      this("", "", 0, 0);
   }

   /**
    * Returns true if the book can be checked out by 
    * the person represented by the specified unity ID
    * @param unityId id of person checking out book
    * @return true if the book can be checked out
    */
   public boolean checkOut(String unityId) {
      if (checkedOut.equals("")) {
         //book is currently in the stacks and can 
         //be checked out
         if (unityId != null) {
            checkedOut = unityId;
            dueDate = new DueDate(new Date(System.currentTimeMillis()), CHECKOUT_LENGTH);
            return true;
         } else {
            return false;
         }
      } else {
         //book is not in the stacks
         return false;
      }
   }

   /**
    * Returns true if the book is successfully checked in
    * @return true if the book is successfully checked in
    */
   public boolean checkIn() {
      checkedOut = ""; //Set back to default
      dueDate = null;
      return true;
   }

   /**
    * Returns the unityId of the person who has the book
    * or an empty string if the book is in the stacks
    * @return unity ID of the person who has the book or
    *         an empty string if the book is in the stacks
    */
   public String getCheckedOutTo() {
      return checkedOut;
   }

   /**
    * Returns the book's location in the stacks
    * @return the book's location in the stacks
    */
   public int getLocation() {
      return location;
   }

   /**
    * Returns the book's title
    * @return the book's title
    */
   public String getTitle() {
      return title;
   }

   /**
    * Returns the book's author
    * @return the book's author
    */
   public String getAuthor() {
      return author;
   }

   /**
    * Returns the book's publication year
    * @return the book's publication year
    */
   public int getPubYear() {
      return pubYear;
   }

   /**
    * Returns the book's due date
    * @return the book's due date
    */
   public DueDate getDueDate() {
      return dueDate;
   }

   /**
    * Sets the book's location in the stacks.  The location
    * must not be negative
    * @param newLocation the book's location
    */
   public void setLocation(int newLocation) {
      if (newLocation < 0) {
         throw new IllegalArgumentException();
      }
      location = newLocation;
   }

   /**
    * Returns a string representation of a Book
    * @return a String representation of a Book
    */
   public String toString() {
      return title + " by " + author + " published in " + pubYear + " stack location " + location + " checked out to " + checkedOut;
   }

   /**
    * Returns true if the object is equal to this object
    * @return true if the object is equal to this object
    */
   public boolean equals(Object o) {
      if (o instanceof Book) {
         Book b = (Book)o;
         return title.equals(b.getTitle()) && author.equals(b.getAuthor()) && pubYear == b.getPubYear();
      } else {
         return false;
      }
   }


}










