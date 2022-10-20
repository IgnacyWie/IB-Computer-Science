import java.lang.Math.*;

public class Main {
	public static void main(String []args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(i+":"+fibonacci(i));
		}
	}

	static int fibonacci(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else if (n > 2)
			return fibonacci((n-1) + fibonacci(n-2));
		else
			return 0;
	}
}
