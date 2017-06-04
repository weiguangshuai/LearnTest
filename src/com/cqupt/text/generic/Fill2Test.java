package com.cqupt.text.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author weigs
 * @date 2017/6/4 0004
 */
public class Fill2Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<String>(list), String.class, 3);
        Fill2.fill(new AddableCollectionAdapter<String>(list), String.class, 2);
        for (String c : list) {
            System.out.println(c);
        }
    }
}

class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken,
                                int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator,
                                int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

interface Addable<T> {
    void add(T t);
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}


