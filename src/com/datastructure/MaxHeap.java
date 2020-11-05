package com.datastructure;

/**
 *  * 实例MaxHeap
 *  * 大根堆
 *  * @version 1.0
 *  
 */
public class MaxHeap {

    private int[] heap;
    private final int limit;
    private int heapSize;

    public MaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void heapInsert(int[] arr, int index) {
        //儿子节点 index 大于 父节点 (index - 1) / 2 则需要交换父子节点位置
        //如index = 0，子节点 小于 父节点，则停止
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, arr[index], arr[(index - 1) / 2]);
            index = (index - 1) >> 1;
        }
    }

    /**
     * 从index 向下沉，行程大根堆
     * 我的孩子都比我小；或者 已经没有孩子了 -> 停止
     */
    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ans;
    }

    public void push(int value) {
        if (this.isFull()) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize++] = value;
        heapInsert(heap, heapSize);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
