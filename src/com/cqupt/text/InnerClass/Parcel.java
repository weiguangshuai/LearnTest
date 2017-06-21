package com.cqupt.text.InnerClass;

/**
 * @author weigs
 * @date 2017/6/8 0008
 */
public class Parcel {
    class Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }

    //嵌套类（静态内部类）
    static class Destination{
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
//        Parcel.Contents c = parcel.new Contents();
        Contents c = parcel.new Contents();
        System.out.println(c.value());
        //嵌套类的创建
        Destination destination = new Destination("weigs");
        System.out.println(destination.readLabel());
    }
}
