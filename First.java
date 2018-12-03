public class First
{
     private int secretNumber;  //instance variable. What a first KNOWS
     //this ushers your class into existence.
     public First(int _secretNumber)
     {
          secretNumber = _secretNumber;
     } 
     int purpose(int x) //method. It is a thing a class DOES.
     {
          return secretNumber * x * x;
     }
}
