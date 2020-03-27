
public class FindPrime {

	private static final int number = 139;

	public static void main(String[] args) {
		System.out.println(findPrime(number));
	}

	private static String findPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			System.out.println(i);
			if (number % i == 0) {
				return "Not Prime";
			}
		}
		return "Prime";
	}

}
