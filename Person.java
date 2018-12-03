public class Person
{
     private static int nextID;
     static
     {
          nextID = 1;
     }
     private final int UNIID;
     private String lastName;
     private String firstName;
     private String middleName;
     public Person(String _lastName, String _firstName, String _middleName)
     {
          lastName = _lastName;
          middleName = _middleName;
          firstName = _firstName;
          UNIID = nextID;
          nextID++;
     }
     public String toString()
     {
          return lastName + ", " + firstName + " " + middleName + ", ID: " + UNIID;
     }
}
