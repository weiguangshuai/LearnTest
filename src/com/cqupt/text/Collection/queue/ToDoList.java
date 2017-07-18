package com.cqupt.text.Collection.queue;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.PriorityQueue;

/**
 * 优先级队列
 * @author weigs
 * @date 2017/7/14 0014
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String item, char primary, int secondary) {
            this.item = item;
            this.primary = primary;
            this.secondary = secondary;
        }


        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return 1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary)
                    return 1;
                else if (secondary == o.secondary)
                    return 0;
            }

            return -1;
        }

        @Override
        public String toString() {
            return "ToDoItem{" +
                    "primary=" + primary +
                    ", secondary=" + secondary +
                    ", item='" + item + '\'' +
                    '}';
        }
    }

    public void add(String item, char primary, int secondary) {
        super.add(new ToDoItem(item, primary, secondary));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        while (!toDoList.isEmpty())
            System.out.println(toDoList.remove());
    }
}
