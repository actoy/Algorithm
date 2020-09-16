package com.sort;

/**
 *  * 实例QuickSort
 *  *
 *  * @version 1.0
 *  
 */
public class QuickSort extends Sort {

    public static void quickSort(int[] arr) {

    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr = generateRandomArray(maxSize, maxValue);
        quickSort(arr);
        printArray(arr);
    }
}