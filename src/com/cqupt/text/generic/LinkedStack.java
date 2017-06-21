package com.cqupt.text.generic;

/**
 * 堆栈类
 * @author weigs
 * @date 2017/6/1 0001
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();//结束点

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (String s : "phasers on my demo".split(" "))
            linkedStack.push(s);
        String s;
        while ((s = linkedStack.pop()) != null) {
            System.out.println(s);
        }
    }
}
