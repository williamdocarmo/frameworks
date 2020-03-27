
public class CalculateFactorial {
	
	private static final int number = 10;
	
	public static void main(String[] args) {
		System.out.println(calculateFactorial(number));
	}

	private static int calculateFactorial(int number) {
		int factorial = 1;
		while (number>0) {
			factorial = factorial*number;
			number--;
		}
		return factorial;
	}

}
