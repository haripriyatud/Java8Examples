import java.util.Arrays;
import java.util.List;

class EmployeeDao {
	
	public List<Employee> createEmployeeList(){
		Employee e1 = new Employee("Adam", 30000, 45, "sales", "Male", 5);
		Employee e2 = new Employee("John", 30050, 47, "engineering", "Male", 3);
		Employee e3 = new Employee("Mark", 25050, 30, "HR", "Male", 6);
		Employee e4 = new Employee("Tara", 30670, 32, "sales", "Female", 5);
		Employee e5 = new Employee("Samuel", 35050, 42, "marketing", "Male", 7);
		Employee e6 = new Employee("Anna", 27050, 28, "maintenance", "Female", 4);
		Employee e7 = new Employee("Peter", 28050, 35, "HR", "Male", 3);
		Employee e8 = new Employee("Daniel", 23000, 29, "sales", "Male", 6);

		List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8);
		return employees;
	}

}
