
public class CheckConsecutiveInteger {

	private static final int[] arrA = { 9, 1, 5, 6, 0, 8, 4, 2, 3, 7 };
	private static final int[] arrB = { 9, 1, 5, 6, 0, 6, 4, 2, 3, 7 };

	public static void main(String[] args) {
		if (checkConsecutiveInteger(arrB)) {
			System.out.println("Consecutive");
		} else {
			System.out.println("Not Consecutive");
		}
	}

	private static boolean checkConsecutiveInteger(int[] numbers) {
		int max = findMax(numbers);
		int min = findMin(numbers);
		boolean flag = false;
		for (int i = min; i < max; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[j] == i) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	private static final int findMax(int[] numbers) {
		int max = 0;
		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;

	}

	private static final int findMin(int[] numbers) {
		int min = numbers[0];
		for (int number : numbers) {
			if (number < min) {
				min = number;
			}
		}
		return min;
	}

}
