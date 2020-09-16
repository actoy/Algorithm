package com.leetcode;

/**
 *  * 实例LeetCode7
 *  * 整数反转(假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0)
 *  * @version 1.0
 *  
 */
public class LeetCode7 {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int negative;
        negative = x < 0 ? -1 : 1;
        x *= negative;
        double result = 0;
        while(x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        //判断是否超过了int的数值范围。result使用double表示
        if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return negative * (int)result;
    }

}
