package com.jc;

public class Sorting {
    private boolean shouldSwap(int val1, int val2, boolean isAscending) {
        return isAscending ? val1 > val2 : val1 < val2;
    }

    // Method - Simple Exchanging
    public void bubbleSort(int[] arr, boolean isAscending) {
        // Time Complexity = N loops * N loops = O(N^2)
        // Space Complexity = O(N)
        for (int i = 0; i < arr.length; i++) {
            // If no swaps in inner loop, then already sorted
            boolean swapped = false;

            // Each iteration of i moves largest to the end
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (shouldSwap(arr[j], arr[j + 1], isAscending)) {
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

    // Method - Simple Insertion
    public void insertionSort(int[] arr, boolean isAscending) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (shouldSwap(arr[i-1], arr[i], isAscending)){
                // push left until correct position in sorted portion
                for (int j = i; j > 0; j--) {
                    if (!shouldSwap(arr[j-1], arr[j], isAscending)) {
                        break;
                    }
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
