class MyClass<T> {
	T obj;

	MyClass(T obj) {
		this.obj = obj;
	}

	public T getVal() {
		return this.obj;
	}
}

enum Name {
	A, B, C;
}

public class JavaGeneric {

	public static void main(String[] args) {
		MyClass<Integer> ival = new MyClass<Integer>(10);
		System.out.println(ival.getVal() + " " + Name.A);
	}
}
