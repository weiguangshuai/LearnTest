package com.cqupt.text.book.data0612;

import java.util.TreeSet;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class p565 {

    public static void main(String[] args) {
        new p565().go();
    }


    public void go() {
        Book b1 = new Book("java");
        Book b2 = new Book("perl");
        Book b3 = new Book("python");
        Book b4 = new Book("java");

        TreeSet<Book> treeSet = new TreeSet<>();
        treeSet.add(b1);
        treeSet.add(b2);
        treeSet.add(b3);
        treeSet.add(b4);
        for (Book book : treeSet) {
            System.out.println(book);
        }
    }
}

class Book implements Comparable<Book>{
   String title;
   public Book(String title) {
       this.title = title;
   }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
