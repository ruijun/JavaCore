package leetcode.palindrome;

import java.util.Stack;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * https://leetcode-cn.com/problems/palindrome-number/
 * <p>
 * https://leetcode-cn.com/problems/palindrome-number/solution/chao-xiang-xi-tu-jie-san-chong-jie-fa-9-hui-wen-sh/
 *
 * @author rj-liang
 * @date 2020/10/28 11:16
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public static boolean isValid(String s) {
        String str = "{[]}";
        // 1.特判
        if (s.isEmpty()) return true;
        // 2.创建辅助栈
        Stack<Character> stack = new Stack<>();
        // 3.遍历
        for (char c : s.toCharArray()) {
            if (c == '(') {
                System.out.println("-------->1");
                stack.push(')');
            } else if (c == '[') {
                System.out.println("-------->2");
                stack.push(']');
            } else if (c == '{') {
                System.out.println("-------->3");
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                System.out.println("-------->4");
                return false;
            }
        }
        System.out.println("-------->5");
        // 4.返回
        return stack.isEmpty();
    }
}
