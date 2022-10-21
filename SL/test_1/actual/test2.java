import java.lang.Math.*;

public class Main {
	public static void main(String []args) {
		double a = 1357;
		double b = 100;
		double c = -12;

		double delta = b*b - (4 * a * c);

		if (delta > 0) {
			double x_1 = (b - Math.sqrt(delta)) / 2*a;
			double x_2 = (b + Math.sqrt(delta)) / 2*a;

			double calculation = x_1 + x_2 + x_1 * x_2;

			if (calculation >= 0) {
				System.out.println("The result is greater or equal than 0");
			} else {
				System.out.println("The result is less than 0");
			}
		} else {
			System.out.println("Cannot calculate x_1 and x_2");
		}
	}

}
