public class SPA extends Staff
{
     private int grade;
     public SPA(String _last, String _first, String _middle, int _years, int _grade)
     {
          super(_last, _first, _middle, _years);
          grade = _grade;
     }
     public int getSalary()
     {
          return (int) Math.pow(10, .02*grade + 3.39);
     }
}
