
import java.io.*;
import java.util.*;

public class TryWithResources {

	public static void main(String[] args) throws Exception {

		/*
		 * The try-with-resources statement automatically closes all the resources at
		 * the end of the statement. A resource is an object to be closed at the end of
		 * the program.
		 * 
		 * we dont need to use finally for closing the resources The try-with-resources
		 * statement does automatic resource management. We need not explicitly close
		 * the resources as JVM automatically closes them. This makes the code more
		 * readable and easier to write.
		 */

		//try with resources
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());

			System.out.println(a + b);
		}

		try (Scanner sc = new Scanner(new File("D:\\IVSALicense.txt"))) {
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				System.out.println(data);
			}
		} /*
			 * catch (FileNotFoundException e) { e.printStackTrace(); }
			 */
	}
}
