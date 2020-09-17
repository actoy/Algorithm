package com.datastructure;

/**
 *  * 实例RingArray
 *  *
 *  * @version 1.0
 *  数组实现队列
 */
public class RingArray {

    public static class MyQueue {
        private int size;
        private final int limit;
        private int pushIndex;
        private int pollIndex;
        private int[] arr;

        public MyQueue(int limit) {
            this.limit = limit;
            pushIndex = 0;
            pollIndex = 0;
            size = 0;
            arr = new int[limit];
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int value = arr[pollIndex];
            pollIndex = nextIndex(pollIndex);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }
}
