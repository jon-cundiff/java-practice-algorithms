package com.jc;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] sampleArray = {5, 23, 12, 1, 43, -5, 3 ,0, 54};
        int[] sampleArray2 = {-8, 11, 5, 23, 12, 1, 43, -5, 3 ,0, 54, 43, 3, -1};

        System.out.println(Arrays.toString(sampleArray));
        Sorting.bubbleSort(sampleArray, true);
        System.out.println(Arrays.toString(sampleArray));

        System.out.println(Arrays.toString(sampleArray2));
        Sorting.bubbleSort(sampleArray2, false);
        System.out.println(Arrays.toString(sampleArray2));
    }
}
