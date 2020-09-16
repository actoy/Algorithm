package com.my.leetcode;

/**
 *  * 实例LeetCode537
 *  *
 *  * @version 1.0
 *  给定俩个复数的字符串
 *  返回表示它们乘积的字符串。注意，根据定义i^2 = -1
 *  eg: a = "1+1i", b = "1+1i" output："0+2i" => (1 + i) * (1 + i) = 1 + 2i + i ^ 2 = 1 - 1 + 2i = 2i
 *  eg: a = "1+-1i", b = "1+-1i" output："0+-2i" => (1 - i) * (1 - i) = 1 - 2i + i ^ 2 = 1 - 1 - 2i = -2i
 *  1.输入字符串不包含额外的空格
 *  2.输入字符串将以a+bi的形式给出，其中整数a和b的范围均在[-100, 100]之间。输出也应当符合这种形式
 */
public class LeetCode537 {
    public static String complexNumberMultiply(String a, String b) {
        // (x + yi) * (m + ni) = x * m  - y * n + i * (x * n + y * m)
        String[] first = a.split("\\+|i");
        String[] second = b.split("\\+|i");
        int x = Integer.parseInt(first[0]);
        int y = Integer.parseInt(first[1]);
        int m = Integer.parseInt(second[0]);
        int n = Integer.parseInt(second[1]);
        return (x * m - y * n) + "+" + (x * n + y * m) + "i";
    }

    public static void main(String[] args) {
        String a = "1+1i";
        String b = "1+-1i";
        System.out.println(complexNumberMultiply(a, b));
    }
}
