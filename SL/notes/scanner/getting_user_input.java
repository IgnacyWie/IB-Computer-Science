import java.util.Scanner;

public class Main {
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);

		if (scan.hasNextDouble()) {
		    System.out.println("Your input was valid:" + scan.nextDouble());
		} else {
			 System.out.println("Your Input was not valid");
		}
	}

}
