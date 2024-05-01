public class Employee {

	String name;
	int salary;
	int age;
	String department;
	String gender;
	int experience;

	Employee(String name, int salary, int age, String department, String gender,int experience) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.department = department;
		this.gender = gender;
		this.experience=experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
	    return "Employee{name='" + name + "', salary=" + salary + ", age=" + age + ", department='" + department + "', gender='" + gender + "', experience=" + experience + '}';

}
	
}

