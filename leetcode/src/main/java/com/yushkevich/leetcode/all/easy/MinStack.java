package com.yushkevich.leetcode.all.easy;

import java.util.Stack;
import java.util.TreeMap;

public class MinStack {

    TreeMap<Integer, Integer> max;
    Stack<Integer> stack;

    public MinStack() {
        this.max = new TreeMap<>();
        this.stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        Integer numberOfElements = max.getOrDefault(x, 0);
        max.put(x, numberOfElements + 1);
    }

    public void pop() {
        Integer element = stack.peek();
        stack.pop();
        Integer numberOfElements = max.get(element);
        if (numberOfElements == 1) {
            max.remove(element);
        } else {
            max.put(element, numberOfElements - 1);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return max.firstKey();
    }
}
