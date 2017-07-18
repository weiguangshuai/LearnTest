package com.cqupt.text.Collection.set;

/**
 * @author weigs
 * @date 2017/7/13 0013
 */
public class SetType {
    int i;

    public SetType(int n) {
        i = n;
    }

    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType) o).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
