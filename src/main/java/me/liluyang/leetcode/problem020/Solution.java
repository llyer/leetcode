package me.liluyang.leetcode.problem020;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 *
 * 是否是有效的括号，数组为以下三种括号的组合 “{}” “[]” “()”
 */
public class Solution {

    public static void main(String[] args) {
        char c = 'a';
        System.out.println(c == 'a');
        System.out.println(isValid("{[]{}}"));

    }

    /**
     *
     * 这道题完美契合栈的所有特点，使用栈可以直接匹配解决
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (stack.size() > 0) {
                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.size() == 0 ? true : false;
    }

}
