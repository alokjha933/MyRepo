
public interface Java8Interface {

	int add(int a, int b);

	default int sub(int a, int b) {
		return a - b;
	}

	static int mult(int a, int b) {
		return a * b;
	}
}
