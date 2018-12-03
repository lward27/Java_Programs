public class Faculty extends Staff
{
     public Faculty(String _last, String _first, String _middle, int _yearsExperience)
     {
          super(_last, _first, _middle, _yearsExperience);
     }
     public int getSalary()
     {
          return 40000 + 2000*getyearsExperience();
     }
}
