package com.cqupt.text.Collection.collection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author weigs
 * @date 2017/7/13 0013
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> iterator;
    private static ListIterator<String> listIterator;

    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        b = a.contains("1");
        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        iterator = a.iterator();
        listIterator = a.listIterator();
        listIterator = a.listIterator(1);
        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> iterator = a.listIterator();
        iterator.add("47");
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.set("47");
    }
}
