package com.cqupt.text.Collection.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author weigs
 * @date 2017/7/13 0013
 */
public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("ten");
        collection.add("one");
        collection.add("two");
        collection.add("three");

        Object[] array = collection.toArray();
        for (Object s : array) {
            System.out.println(s);
        }

        System.out.println("collections.max(c)=" + Collections.max(collection));
    }
}
