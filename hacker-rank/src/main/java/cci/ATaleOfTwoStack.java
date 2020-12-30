package cci;

import java.util.Scanner;

public class ATaleOfTwoStack {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    static class MyQueue<T> {
        private Node<T> head;
        private Node<T> tail;

        void enqueue(T data) {
            Node<T> node = new Node<>(data);

            if (tail != null) {
                tail.next = node;
            }
            tail = node;

            if (head == null) {
                head = node;
            }
        }

        T peek() {
            if (head == null) {
                return null;
            }
            return head.data;
        }

        void dequeue() {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }

        private static class Node<T> {
            private T data;
            private Node<T> next;

            private Node(T data) {
                this.data = data;
            }
        }
    }
}
