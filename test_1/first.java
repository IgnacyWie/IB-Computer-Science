import java.lang.Math.*;

public class Main {
	public static void main(String []args) {
		double a = 1357;
		double b = 100;
		double c = -12;
		double max;
		double arithMean;
		double geoMean;
		double x;

		if (a > b)
			if (a > c)
				max = a;
			else 
				max = c;
		else 
			if (b > c)
				max = b;
			else 
				max = c;

		arithMean = arithMean(a=a, b=b, c=c);
		geoMean = geoMean(a, b, c);
		x = max - arithMean;

		System.out.println("The result is " + x);

		if (x > geoMean)
			System.out.println("Operation with the arithmetic mean gives greater result");
		else 
			System.out.println("Geometric mean gives greater result");
	}

	static double arithMean(double a, double b, double c) {
		double mean = (a + b + c) / 3;
		return mean;
	}

	static double geoMean(double a, double b, double c) {
		double mean = Math.sqrt(a*a + b*b + c*c);
		return mean;
	}
}
