package com.yushkevich.leetcode.all.easy;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> opens = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                opens.push(c);
            } else if (!opens.isEmpty()) {
                char open = opens.pop();
                if (open == '[' && c == ']'
                        || open == '{' && c == '}'
                        || open == '(' && c == ')')
                    continue;

                return false;
            } else {
                return false;
            }
        }

        return opens.isEmpty();
    }
}
