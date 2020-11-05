package com.sort;

import com.datastructure.MaxHeap;

/**
 *  * 实例HeapSort
 *  * 堆排序
 *  * @version 1.0
 *  
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = arr.length - 1; i >= 0; --i) {
            maxHeap.heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        maxHeap.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            maxHeap.heapify(arr, 0, heapSize);
            maxHeap.swap(arr, 0, --heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

}
