package com.datastructure;

import java.util.Stack;

/**
 *  * 实例TwoStacksImplementQueue
 *  *
 *  * @version 1.0
 *  通过两个栈实现队列
 */
public class TwoStacksImplementQueue {

    public static class TwoStacksQueue<T> {

        private Stack <Integer> stackPush;
        private Stack <Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack <Integer>();
            stackPop = new Stack <Integer>();
        }

        public void offset(int value) {
            stackPush.push(value);
            pushToPop();
        }

        // push栈向pop栈倒入数据
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public int pop() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("stack is all empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("stack is all empty");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.offset(1);
        test.offset(2);
        test.offset(3);
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
    }
}
