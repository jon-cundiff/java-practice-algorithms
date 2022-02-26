package com.jc;

import java.util.Arrays;

public class Main {
    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] cloneSample(int sampNum) {
        int[] sampleArray = {5, 23, 12, 1, 43, -5, 3 ,0, 54, 5};
        int[] bubble2 = {-8, 11, 5, 23, 12, 1, 43, -5, 3 ,0, 54, 45, 3, -1};

        return sampNum == 1 ? sampleArray : bubble2;
    }

    public static void showSorting() {
        Sorting sort = new Sorting();

//        System.out.println("Bubble Sort");
//        var bubble1 = cloneSample(1);
//        printArr(bubble1);
//        sort.bubbleSort(bubble1, true);
//        printArr(bubble1);
//
//        var bubble2 = cloneSample(2);
//        printArr(bubble2);
//        sort.bubbleSort(bubble2, false);
//        printArr(bubble2);
//
        System.out.println("\nInsertion Sort");
        var insertion1 = cloneSample(1);
        printArr(insertion1);
        sort.insertionSort(insertion1, true);
        printArr(insertion1);

        var insertion2 = cloneSample(2);
        printArr(insertion2);
        sort.insertionSort(insertion2, false);
        printArr(insertion2);

//        System.out.println("\nMerge Sort");
//        var merge1 = cloneSample(1);
//        printArr(merge1);
//        sort.mergeSort(merge1, 0, merge1.length - 1, true);
//        printArr(merge1);
//
//        var merge2 = cloneSample(2);
//        printArr(merge2);
//        sort.mergeSort(merge2, 0, merge2.length - 1, false);
//        printArr(merge2);

        System.out.println("\nQuick Sort");
        var quick1 = cloneSample(1);
        printArr(quick1);
        sort.quickSort(quick1, 0, quick1.length - 1, true);
        printArr(quick1);

        var quick2 = cloneSample(2);
        printArr(quick2);
        sort.quickSort(quick2, 0, quick2.length - 1, false);
        printArr(quick2);
    }

    public static void showMath() {
        MathAlgo math = new MathAlgo();

        int[] numsToTest = {-1, 2, 3, 5, 4, 21417, 21419, 124882, 260091049, 260091077};

        for (int num: numsToTest) {
            String isPrimeText = math.isPrime(num) ? "Prime" : "Not Prime";
            System.out.printf("%s : %s\n", num, isPrimeText);
        }
    }

    public static void showSearch() {
        Searching search = new Searching();

        int[] linear = cloneSample(1);
        int linearIndex1 = search.linearSearch(linear, 43);
        System.out.println(linearIndex1);

        int linearIndex2 = search.linearSearch(linear, 15);
        System.out.println(linearIndex2);
    }

    public static void main(String[] args) {
//        showSorting();
//        showMath();
        showSearch();
    }
}
