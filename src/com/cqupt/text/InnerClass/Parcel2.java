package com.cqupt.text.InnerClass;

/**
 * @author weigs
 * @date 2017/6/8 0008
 */
public class Parcel2 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            public int value() {
                return super.value() * 47;
            }
            public int getI(){
                return this.value();
            }
        };
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        Wrapping wrapping = parcel2.wrapping(2);
        System.out.println(wrapping.getI());
    }
}

class Wrapping {
    private int i;

    public Wrapping(int x) {
        i = x;
    }

    public int value() {
        return i;
    }
    public int getI() {
        return i;
    }
}
