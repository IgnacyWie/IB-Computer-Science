import java.lang.Math.*;

public class Main {
	public static void main(String []args) {
		static double a = 2;
		static double b = 200;
		static double c = 4;
		static double delta;
		static double x_one;
		static double x_two;
		static double sum;
		static double product;

		delta = b*b - (4 * a * c);
		
		if (delta > 0) {
			x_one = (-b + Math.sqrt(delta))/(2*a);
			x_two = (-b + Math.sqrt(delta))/(2*a);

			sum = x_one + x_two;
			product = x_one * x_two;

			if (sum >= product)
				System.out.println("The sum is greater than or equal to");
			else 
				System.out.println("The result of the multiplication is greater");
		}
		else {
			System.out.println("There are no two roots");
		}
	}
}
