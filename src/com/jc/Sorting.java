package com.jc;

public class Sorting {
    // For algorithms that push towards right
    private boolean shouldSwap(int val1, int val2, boolean isAscending) {
        return isAscending ? val1 > val2 : val1 < val2;
    }

    // For algorithms that merge starting from left
    private boolean isFirst(int val1, int val2, boolean isAscending) {
        return isAscending ? val1 < val2 : val1 > val2;
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
                    if (!isFirst(arr[j-1], arr[j], isAscending)) {
                        break;
                    }
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    private void merge(int[] arr, int left, int middle, int right, boolean isAscending) {
        // length of temp subarrays
        int leftSize = middle - left + 1;  // +1 makes the midpoint included
        int rightSize = right - middle;

        // create temp arrays so sorted order persists to place into main array
        int[] leftArr = new int[leftSize];
        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[i + left];
        }

        int[] rightArr = new int[rightSize];
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = arr[i + middle + 1];  // +1 so middle element isn't duplicated
        }
        int i = left;
        int j = 0;
        int k = 0;


        // fill from both arrays until one runs out
        while (j < leftSize && k < rightSize) {
            if (isFirst(leftArr[j], rightArr[k], isAscending )) {
                arr[i] = leftArr[j];
                j++;
            } else {
                arr[i] = rightArr[k];
                k++;
            }
            i++;
        }

        // fill from remaining elements in sorted left array
        while (j < leftSize) {
            arr[i] = leftArr[j];
            i++;
            j++;
        }

        // fill from remaining elements in sorted right array
        while (k < rightSize) {
            arr[i] = rightArr[k];
            i++;
            k++;
        }
    }

    // Method - Divide and Conquer
    public void mergeSort(int[] arr, int left, int right, boolean isAscending) {
        if (right > left) {
            // split array into half using midpoint
            int middle = left + (right - left) / 2;
            // perform same operations on left half
            mergeSort(arr, left, middle, isAscending);
            // and on the right half
            mergeSort(arr, middle + 1, right, isAscending);

            // combine arrays together while sorting
            merge(arr, left, middle, right, isAscending);
        }
    }
}
