package com.jc;

public class Searching {

    // linear search - O(N) time
    public int linearSearch(int[] arr, int target) {
        // Stepping into each item until we find a match
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }


    // binary search - requires sorted array
    public int binarySearch(int[] arr, int target) {
        int lower = 0;
        int upper = arr.length;

        // Always compare middle element of sorted selection,
        // Then adjust bounds to not include middle element
        // Each iteration cuts sample size in half.
        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }

        return -1;
    }
}
