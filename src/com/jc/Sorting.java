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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
                    swap(arr, j, j + 1);
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
                    swap(arr, j, j-1);
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

    private int partition(int[] arr, int low, int high, boolean isAscending) {
        // make the value of the last index the comparison
        int pivot = arr[high];
        int pivotIndex = low - 1;

        for (int j = low; j <= high; j++) {
            // if value at index j is lower (or higher for descending)
            // than pivot, advance pivot index then swap
            if (isFirst(arr[j], pivot, isAscending)) {
                pivotIndex++;
                swap(arr, pivotIndex, j);
            }
        }

        // values smaller than pivot have indices at or below index.
        // place the pivot value at one above this point
        pivotIndex++;
        swap(arr, pivotIndex, high);

        return pivotIndex;
    }

    // Method - Divide and Conquer Partitions
    public void quickSort(int[] arr, int low, int high, boolean isAscending) {
        if ( low < high) {
            // this index will have the element in the proper place
            int partitionIndex = partition(arr, low, high, isAscending);

            // repeat this process on the two arrays created before and after the pivot
            quickSort(arr, low, partitionIndex - 1, isAscending);
            quickSort(arr, partitionIndex + 1, high, isAscending);
        }
    }
}
