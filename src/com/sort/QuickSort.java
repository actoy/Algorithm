package com.sort;

/**
 *  * 实例QuickSort
 *  *
 *  * @version 1.0
 *  
 */
public class QuickSort extends Sort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R]  [   <=arr[R]   arr[R]    >arr[R]  ]
        int M = partition(arr, L, R);
        process(arr, L, M - 1);
        process(arr, M + 1, R);
    }

    private static int partition(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        //lessEqual => 可能大于 arr[right] 节点的位置，即与该位置交换，可保证左侧都是小于 最后一个节点
        int lessEqual = left;
        while (left < right) {
            if (arr[left] <= arr[right]) {
                swap(arr, left, lessEqual++);
            }
            left++;
        }
        //把最后一个节点放到lessEqual位置上
        swap(arr, lessEqual, right);
        return lessEqual;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int[] arr = generateRandomArray(maxSize, maxValue);
        quickSort(arr);
        printArray(arr);
    }
}