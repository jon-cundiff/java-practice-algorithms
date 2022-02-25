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
        System.out.println(Arrays.toString(bubble1));
        sort.bubbleSort(bubble1, true);
        System.out.println(Arrays.toString(bubble1));

        var bubble2 = cloneSample(2);
        System.out.println(Arrays.toString(bubble2));
        sort.bubbleSort(bubble2, false);
        System.out.println(Arrays.toString(bubble2));

        System.out.println("\nSelection Sort");
    }
}
