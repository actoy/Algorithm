package com.datastructure.stack;

import java.util.Stack;

/**
 *  * 实例RecSize
 *  * 给定一个整形矩阵map，其中的值只有0和1，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
 *  * @version 1.0
 *  eg 1 1 1 0
 *     最大的矩形区域为3
 *     1 0 1 1
 *     1 1 1 1
 *     1 1 1 0
 *     最大的矩形区域为6
 *  
 */
public class RecSize {

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }


    /**
     * 在一维数组中找到目标值 flag
     * 左边 小于 flag 的最近的下标位置 y
     * 右边 小于 flag 的最近的下标位置 x
     * area = ( (y - 1) - (x + 1) + 1 ) * flag = (y - x - 1) * flag
     * 采用单调栈的方式
     */
    public static int maxRecFromBottom(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxRec = 0;
        Stack <Integer> stack = new Stack <Integer>();
        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int j = stack.pop();
                //eg : 1 1 1 0 => k = 0 -> i = 3   3 - 0 - 1 = 2
                //左边<= arr[i] 的最近位置
                int k = stack.isEmpty() ? -1 : stack.peek();
                //右边<= arr[i] 的最近位置(i - 1) - (k + 1) + 1 = i - k - 1
                int area = i - k - 1;
                maxRec = Math.max(maxRec, area * arr[j]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            //左边小 于arr[i] 的最近位置
            int k = stack.isEmpty() ? -1 : stack.peek();
            //剩余stack中的元素 即从j -> arr.length 均大于arr[j]  arr.length - (k + 1);
            int area = arr.length - k - 1;
            maxRec = Math.max(maxRec, area * arr[j]);
        }
        return maxRec;
    }

    public static void main(String[] args) {
        int[][] map = {
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 0}
        };
        System.out.println(maxRecSize(map));
    }
}