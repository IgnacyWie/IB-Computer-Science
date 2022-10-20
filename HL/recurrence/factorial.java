public class Main {
	public static void main(String []args) {
		int test_value = factorial(6);
		System.out.println(test_value);
	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return factorial(n-1) * n;
	}
}
