package com.my.sort;

/**
 *  * 实例BubbleSort
 *  *
 *  * @version 1.0
 *  
 */
public class BubbleSort extends Sort {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 1) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr = generateRandomArray(maxSize, maxValue);
        bubbleSort(arr);
        printArray(arr);
    }

}
