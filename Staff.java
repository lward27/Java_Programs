public abstract class Staff extends Person
{
     private int yearsExperience;
     public Staff(String _lastName, String _firstName, String _middleName, int _yearsExperience)
     {
          super(_lastName, _firstName, _middleName);
          yearsExperience = _yearsExperience;
     }
     public int getyearsExperience()
     {
          return yearsExperience;
     }
     public abstract int getSalary();
}
