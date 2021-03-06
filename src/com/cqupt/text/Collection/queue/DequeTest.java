package com.cqupt.text.Collection.queue;

/**
 * @author weigs
 * @date 2017/7/14 0014
 */
public class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++)
            deque.addFirst(i);
        for (int i = 50; i < 55; i++)
            deque.addLast(i);
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        fillTest(deque);
        System.out.println(deque);
        while (deque.size() != 0)
            System.out.print(deque.removeFirst() + " ");
        System.out.println();
        fillTest(deque);
        while (deque.size() != 0)
            System.out.print(deque.removeLast() + " ");
    }
}
