// client code number 3
public class EmployeeMain3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		Lawyer law = new Lawyer();
		Marketer mark = new Marketer();
		Secretary sec = new Secretary();
		
		printInfo(emp1);
		printInfo(law);
		printInfo(mark);
		printInfo(sec);
	}
	
	public static void printInfo(Employee employee) {
		employee.applyForVacation();
		employee.showHours();
		employee.showSalary();
		employee.showVacation();
		System.out.println();
	}

}
