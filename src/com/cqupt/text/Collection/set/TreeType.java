package com.cqupt.text.Collection.set;

/**
 * @author weigs
 * @date 2017/7/14 0014
 */
public class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int n) {
        super(n);
    }


    @Override
    public int compareTo(TreeType o) {
        return (o.i < i ? -1 : (o.i == i ? 0 : 1));
    }
}
