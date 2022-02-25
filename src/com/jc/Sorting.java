package com.jc;

public class Sorting {
    public static void bubbleSort(int[] arr, boolean isAscending) {
        // Time Complexity = N loops * N loops = O(N^2)
        // Space Complexity = O(N)
        for (int i = 0; i < arr.length; i++) {
            // If no swaps in inner loop, then already sorted
            boolean swapped = false;

            // Each iteration of i moves largest to the end
            for (int j = 0; j < arr.length - i - 1; j++) {
                if ((arr[j] > arr[j + 1] && isAscending) || (arr[j] < arr[j + 1] && !isAscending)) {
                    int temp = arr[j + 1] ;
                    arr[j + 1]  = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }
}
