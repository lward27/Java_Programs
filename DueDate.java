import java.util.*;

/**
 * An immutable class that keeps track of a Date
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 */
public final class DueDate {

   /** A date object that is kept immutable */
   private final Date dueDate;
   /** Constant with the number of milliseconds in a day */
   private static final long ONE_DAY = 86400000;

   /**
    * Constructs a new DueDate object with the current date
    * and the number of days until something is due
    * @param current the current date
    * @param checkOutLength number of days until due
    */
   public DueDate(Date current, int checkOutLength) {
      dueDate = new Date(current.getTime() + (checkOutLength * ONE_DAY));
   }

   /**
    * Default constructor for a DueDate
    */
   public DueDate() {
      dueDate = new Date();
   }

   /**
    * Returns a copy of the due date
    * @return a copy of the due date
    */
   public Date getDueDate() {
      return new Date(dueDate.getTime());
   }
 
   /**
    * Returns a String containing the date
    * @return String containing the date
    */
   public String toString() {
      return dueDate.toString();
   }

}
