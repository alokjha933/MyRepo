import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeStreamImpl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee[] emp = new Employee[2];
		for (int i = 0; i < 2; i++) {
			int id = sc.nextInt();
			String age = sc.next();
			emp[i] = new Employee(id, age);
		}
		streamApiImpl(emp);
		streamApiImplByMap(emp);
		sc.close();
	}

	private static void streamApiImpl(Employee[] emp) {
		List<Employee> empList = Arrays.asList(emp);
		empList.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(emp1 -> {
			System.out.println(emp1);
		});

	}

	private static void streamApiImplByMap(Employee[] emp) {
		List<Employee> empList = Arrays.asList(emp);
		empList.stream().map(i -> i.getName().toLowerCase()).forEach(emp1 -> {
			System.out.println(emp1);
		});

	}
}

class Employee {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}