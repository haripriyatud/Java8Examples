import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Comparator;

public class StreamsAPIExample {

	public static void main(String[] args) {

		EmployeeDao daoclass = new EmployeeDao();

		List<Employee> employees = daoclass.createEmployeeList();

		Predicate<Employee> employees_age_greater_or_equal_to_40 = e -> e.getAge() >= 40;

		Predicate<Employee> employees_with_salary_greater_or_equal_to_30000 = e -> e.getSalary() >= 30000;

		System.out.println("Employees whose salary is greater or equal to 30000");

		System.out.println("----------------------------------------------");

		employees.stream().filter(employees_with_salary_greater_or_equal_to_30000).map(Employee::getName)
				.forEach(System.out::println);
		System.out.println("----------------------------------------------");

		System.out.print("Number of Employees whose age is greater or equal to 40: ");

		long num_employees_age_greater_40 = employees.stream().filter(employees_age_greater_or_equal_to_40).count();

		System.out.println(num_employees_age_greater_40);
		System.out.println("----------------------------------------------");

		System.out.println("Number of Female and Male Employees");

		System.out.println("----------------------------------------------");

		Map<String, Long> noOfMaleAndFemaleEmployees = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(noOfMaleAndFemaleEmployees);

		System.out.println("----------------------------------------------");
		System.out.println("Names distinct departments in employee data");
		System.out.println("----------------------------------------------");
		employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		System.out.println("----------------------------------------------");

		Map<String, Long> employeeCountByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

		System.out.println("No of employees in each department");

		System.out.println("----------------------------------------------");

		for (Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("----------------------------------------------");

		Optional<Employee> highestPaidEmployeeWrapper = employees.stream()
				.max(Comparator.comparingDouble(Employee::getSalary));

		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();

		System.out.println("Details Of Highest Paid Employee : ");

		System.out.println("==================================");

		System.out.println("Name : " + highestPaidEmployee.getName());

		System.out.println("Age : " + highestPaidEmployee.getAge());

		System.out.println("Gender : " + highestPaidEmployee.getGender());

		System.out.println("Department : " + highestPaidEmployee.getDepartment());

		System.out.println("Salary : " + highestPaidEmployee.getSalary());

		System.out.println("==================================");

		Optional<Employee> youngestMaleEmployeeInSalesDepartmentWrapper = employees.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "sales")
				.min(Comparator.comparingInt(Employee::getAge));

		Employee youngestMaleEmployeeInSalesDpartment = youngestMaleEmployeeInSalesDepartmentWrapper.get();

		System.out.println("Details Of Youngest Male Employee In sales");

		System.out.println("----------------------------------------------");

		System.out.println("Name : " + youngestMaleEmployeeInSalesDpartment.getName());

		System.out.println("Age : " + youngestMaleEmployeeInSalesDpartment.getAge());

		System.out.println("Salary : " + youngestMaleEmployeeInSalesDpartment.getSalary());

		System.out.println("----------------------------------------------");

		System.out.println("Number of female and male employees in sales department");

		Map<String, Long> countMaleFemaleEmployeesInSales = employees.stream().filter(e -> e.getDepartment() == "sales")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(countMaleFemaleEmployeesInSales);

		System.out.println("----------------------------------------------");

		System.out.println("Details of oldest employee");

		System.out.println("----------------------------------------------");

		Optional<Employee> oldestEmployeeWrapper = employees.stream().max(Comparator.comparingInt(Employee::getAge));

		Employee oldestEmployee = oldestEmployeeWrapper.get();

		System.out.println("Name : " + oldestEmployee.getName());

		System.out.println("Age : " + oldestEmployee.getAge());

		System.out.println("Department : " + oldestEmployee.getDepartment());

		System.out.println("----------------------------------------------");

		System.out.println("printing the employee list sorted by employee name");

		System.out.println("----------------------------------------------");

		List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());

		sortedEmployees.forEach(System.out::println);

		System.out.println("----------------------------------------------");

		System.out.println("printing the employee details with maximum experience");

		System.out.println("----------------------------------------------");

		Optional<Employee> employeeWithMaxExperience = employees.stream()
				.max(Comparator.comparing(Employee::getExperience));

		employeeWithMaxExperience.ifPresent(employee -> {
			System.out.println("Employee with maximum experience:");
			System.out.println("Name: " + employee.getName());
			System.out.println("Salary: " + employee.getSalary());
		});

		System.out.println("----------------------------------------------");

		System.out.println("printing the average salary of each department");

		System.out.println("----------------------------------------------");

		Map<String, Double> averageSalaryByDepartment = employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDepartment,
		                Collectors.averagingInt(Employee::getSalary)));

		averageSalaryByDepartment.forEach((department, averageSalary) -> {
		    System.out.println("Department: " + department + ", Average Salary: " + averageSalary);
		});
		
		System.out.println("----------------------------------------------");
	}

}
