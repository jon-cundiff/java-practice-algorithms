package com.jc;

import java.util.Arrays;

public class Main {
    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] cloneSample(int sampNum) {
        int[] sampleArray = {5, 23, 12, 1, 43, -5, 3 ,0, 54};
        int[] bubble2 = {-8, 11, 5, 23, 12, 1, 43, -5, 3 ,0, 54, 43, 3, -1};

        return sampNum == 1 ? sampleArray : bubble2;
    }

    public static void main(String[] args) {
        Sorting sort = new Sorting();

        System.out.println("Bubble Sort");
        var bubble1 = cloneSample(1);
        printArr(bubble1);
        sort.bubbleSort(bubble1, true);
        printArr(bubble1);

        var bubble2 = cloneSample(2);
        printArr(bubble2);
        sort.bubbleSort(bubble2, false);
        printArr(bubble2);

        System.out.println("\nInsertion Sort");
        var insertion1 = cloneSample(1);
        printArr(insertion1);
        sort.insertionSort(insertion1, true);
        printArr(insertion1);

        var insertion2 = cloneSample(2);
        printArr(insertion2);
        sort.insertionSort(insertion2, false);
        printArr(insertion2);

    }
}
