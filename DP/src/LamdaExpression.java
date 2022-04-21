
interface functionalInterFace {
	public int fetch(int a, int b);

	default void print() {
		System.out.println("Hey");
	}
}

public class LamdaExpression {

	public static void main(String[] args) {

		int width = 100;
		int a = 10;
		int b = 10;
		// After Java 8 we are using lamda expression for functional interface.
		functionalInterFace fI1 = (int d, int e) -> {
			System.out.println("Value from lamda Expression-> " + width);
			return d + e;
		};
		System.out.println(fI1.fetch(a, b));
		fI1.print();

		// Before java8 we used anonymous class for functional interface.

		functionalInterFace fI = new functionalInterFace() {

			public int fetch(int e, int f) {
				System.out.println("Value from anonymous class () " + width);
				return e + f;
			}
		};
		fI.print();
		System.out.println(fI.fetch(a, b));
	}

}
