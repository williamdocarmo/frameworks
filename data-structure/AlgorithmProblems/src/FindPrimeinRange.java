public class FindPrimeinRange {

	private static final int MIN = 50;

	private static final int MAX = 100;

	public static void main(String[] args) {
		findPrimeInRange(MIN, MAX);
	}

	private static void findPrimeInRange(int min, int max) {
		int[] primeNumbers = new int[(MAX - MIN)/2];
		int counter = 0;
		for (int i = min; i <= max; i++) {
			if (findPrime(i)) {
				primeNumbers[counter] = i;
				counter++;
			}
		}
		for (int number : primeNumbers)
			System.out.println(number);
	}

	private static boolean findPrime(int number) {
		boolean prime = true;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}

}
