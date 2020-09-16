package com.sort;

/**
 *  * 实例SelectionSort
 *  *
 *  * @version 1.0
 *  
 */
public class SelectionSort extends Sort {

    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr = generateRandomArray(maxSize, maxValue);
        selectionSort(arr);
        printArray(arr);
    }
}

