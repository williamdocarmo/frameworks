
public class FindSmallesNumber {
	
	private static final int[] numbers = { 30, 20, 10, 70, 50, 40, 60, 90, 80, 100 };

	public static void main(String[] args) {
		System.out.println(findSmallestNumber(numbers));
	}

	private static int findSmallestNumber(int[] numbers) {
		int min = numbers[0];
		for (int number : numbers) {
			if (number < min)
				min = number;
		}
		return min;
	}

}
