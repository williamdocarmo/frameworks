
public class FindSum {

	private static final int[] numbers = { 30, 20, 10, 70, 50, 40, 60, 90, 80, 100 };

	public static void main(String[] args) {
		System.out.println(findFum(numbers));
	}

	private static int findFum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

}
