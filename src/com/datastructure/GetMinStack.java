package com.datastructure;

import java.util.Stack;

/**
 *  * 实例GetMinStack
 *  *
 *  * @version 1.0
 *  
 */
public class GetMinStack {

    public static class MyMinStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public void push(int value) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(value);
            } else if (value <= this.getMin()) {
                this.stackMin.push(value);
            }
            this.stackData.push(value);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("the stackData is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("the stackMin is empty");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyMinStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyMinStack2() {
            this.stackData = new Stack <Integer>();
            this.stackMin = new Stack <Integer>();
        }

        public void push(int value) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(value);
            } else if (value < this.getMin()) {
                this.stackMin.push(value);
            } else {
                this.stackMin.push(this.getMin());
            }
            this.stackData.push(value);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("the stackData is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("the stackMin is empty");
            }
            return this.stackMin.peek();
        }
    }

}
