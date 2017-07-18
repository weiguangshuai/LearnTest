package com.cqupt.text.Collection.queue;

import java.util.LinkedList;

/**
 * 双向队列
 *
 * @author weigs
 * @date 2017/7/14 0014
 */
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T t) {
        deque.addFirst(t);
    }

    public void addLast(T t) {
        deque.addLast(t);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    public String toString() {
        return deque.toString();
    }
}
