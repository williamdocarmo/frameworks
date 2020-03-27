package com.algorithm.sorting;

import com.algorithm.utils.Util;

public class SelectionSort {

	private static final Integer[] numbers = { 9, 2, 5, 1, 4, 6, 8, 0, 3, 7 };

	public static void main(String[] args) {
		System.out.println("Before Sorting: "+ Util.printArray(numbers));
		sort(numbers);
		System.out.println("After Sorting: "+ Util.printArray(numbers));
	}

	private static void sort(Integer[] numbers) {
		int n = numbers.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (numbers[j] < numbers[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = numbers[min_idx];
			numbers[min_idx] = numbers[i];
			numbers[i] = temp;
		}
	}

}
