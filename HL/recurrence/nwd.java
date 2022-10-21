public class Main {
	public static void main(String []args) {
		double l1 = 56;
		double l2 = 24;

		GCD(l1, l2);
	}

	public static void GCD(double l1, double l2) {
		if (l1 == l2) {
			System.out.println(l1);
		} else {
			if (l1 > l2) {
				l1 = l1/(l1-l2);
				GCD(l1, l2);
			} else {
				l2 = l2/(l2-l1);
				GCD(l1, l2);
			}
		}
	}
}
