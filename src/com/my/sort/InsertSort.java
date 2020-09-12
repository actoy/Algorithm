package com.my.sort;

/**
 *  * 实例InsertSort
 *  *
 *  * @version 1.0
 *  
 */
public class InsertSort extends Sort {

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr = generateRandomArray(maxSize, maxValue);
        insertSort(arr);
        printArray(arr);
    }

}
