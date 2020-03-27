
public class FindBiggestNumber {

	private static final int[] numbers = { 30, 20, 10, 70, 50, 100, 60, 90, 80, 40 };

	public static void main(String[] args) {
		System.out.println(findBigggestNumber(numbers));
	}

	private static int findBigggestNumber(int[] numbers) {
		int max = 0;
		for (int number : numbers) {
			if (number > max)
				max = number;
		}
		return max;
	}

}
