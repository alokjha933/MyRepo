
public class MainClassForMarkerInterface {

	public static void main(String[] args) {

		MarkerInterface m = new MarkerInterface();
		if (m instanceof MarkerInter) {
			m.show();
		} else {
			System.out.println("Access denied");
		}
	}

}
