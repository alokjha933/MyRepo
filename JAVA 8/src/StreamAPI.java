import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

interface FunctionalInterface {
	public void add(int a, int b);
}

interface Ianonymous {
	public void show();
}

public class StreamAPI {

	static int i = 10;

	public void hey() {
		int a = 1;
		System.out.println(a);
	}

	int a = 0;

	public static void main(String[] args) {

		FunctionalInterfacePrac func = new FunctionalInterfacePrac() {

			@Override
			public void prinHello() {
				System.out.println("Hello");
			}
		};
		func.prinHello();

		FunctionalInterfacePrac func1 = () -> {
			System.out.println("Helloo");
		};
		func1.prinHello();

		// try with resources
		File file = new File("/D:/IVSALicense.txt");
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {
				System.out.print(sc.nextLine());
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
