package com.jc;

public class Sorting {
    public static void bubbleSort(int[] arr, boolean isAscending) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] < arr[j] && isAscending) || (arr[i] > arr[j] && !isAscending)) {
                    int temp = arr[i] ;
                    arr[i]  = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
