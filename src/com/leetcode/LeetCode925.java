package com.leetcode;

import java.util.Scanner;

/**
 *  * 实例LeetCode925
 *  * @version 1.0
 *  你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *  你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True
 *      提示：
 *          name.length <= 1000
 *          typed.length <= 1000
 *          name 和 typed 的字符都是小写字母。
 *  eg: 输入：name = "alex", typed = "aaleex"
 *      输出：true
 *      输入：name = "saeed", typed = "ssaaedd"
 *      输出：false
 */
public class LeetCode925 {

    public static boolean isLongPressedName(String name, String typed) {
        int length1 = name.length();
        int length2 = typed.length();
        int namePos = 0;
        int typedPos = 0;
        //第一元素 必须一样，否则返回false
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        while (namePos < length1 && typedPos < length2) {
            //如果当前位置元素相等，name 指针右移一位
            //如果当前位置元素不相等，typed的相邻位置元素需要相等，否则出入内容不连续一致
            if (name.charAt(namePos) == typed.charAt(typedPos)) {
                namePos++;
            } else if (typedPos != 0 && typed.charAt(typedPos - 1) != typed.charAt(typedPos)) {
                return false;
            }
            typedPos++;
        }
        //如果剩余的typed元素需要全部一致
        while (typedPos < length2) {
            if (typed.charAt(typedPos - 1) != typed.charAt(typedPos)) {
                return false;
            }
            typedPos++;
        }
        return namePos == length1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String typed = scanner.next();

        System.out.println(isLongPressedName(name, typed));
    }
}
