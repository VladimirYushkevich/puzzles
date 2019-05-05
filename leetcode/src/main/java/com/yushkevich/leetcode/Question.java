package com.yushkevich.leetcode;

import java.util.Stack;

public class Question {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("(){[]}"));
        System.out.println(isValid("(){[]}["));
        System.out.println(isValid("(){[]}[}"));
    }

    private static boolean isValid(String input) {
        Stack<Character> opens = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                opens.push(c);
            } else {
                char open = opens.pop();
                boolean res = false;
                switch (open) {
                    case '[':
                        res = c == ']';
                        break;
                    case '{':
                        res = c == '}';
                        break;
                    case '(':
                        res = c == ')';
                        break;
                }

                if (!res) {
                    return false;
                }
            }
        }

        return opens.isEmpty();
    }

}
