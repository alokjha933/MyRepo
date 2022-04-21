package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {

		// filter with name
		List<String> nameList = Arrays.asList("Alok", "Alpha", "Aman", "Shubham", "Ankur", "Main");
		List<String> name = nameList.stream().filter(i -> i.startsWith("A")).collect(Collectors.toList());
		System.out.println("Name Starts With A: " + name.toString());
		List<String> name1 = nameList.stream().filter(i -> i.startsWith("A")).map(i -> i.toLowerCase())
				.collect(Collectors.toList());
		System.out.println("Name Starts With A and return in lower case: " + name1.toString());

		// find name with max Age
		List<Employee> empList = Arrays.asList(new Employee(22, "Alok"), new Employee(23, "Alpha"),
				new Employee(20, "AMAN"), new Employee(25, "SHUBHAM"), new Employee(18, "Alka"));
		Employee empList1 = empList.stream().sorted(Comparator.comparingInt(Employee::getAge))
				.collect(Collectors.toList()).get(empList.size() - 1);
		// System.out.println(empList.stream().sorted(Comparator.comparingInt(Employee::getAge)).toString());
		System.out.println(empList1.getName());

		List<String> emp2 = empList.parallelStream().map(i -> i.getName()).collect(Collectors.toList());
		System.out.println(emp2.toString());

		List<Integer> emp12 = empList.stream().map(i -> i.getAge()).toList();
		Integer emp3 = emp12.stream().reduce(0, (i, j) -> i + j);
		System.out.println(emp3);

	}

}
