
public class Java8InterfaceImpl {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
		System.out.println(obj.add(2, 3));
		int abc = obj.sub(5, 3);
		abc = obj.sub(5, 4);
		System.out.println(abc);

		int cde = Java8Interface.mult(2, 4);
		cde = Java8Interface.mult(2, 5);
		System.out.println(cde);

	}

}
