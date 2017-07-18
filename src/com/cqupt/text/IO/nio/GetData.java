package com.cqupt.text.IO.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer可以从其所容纳的字节中产生各种不同基本类型的方法
 *
 * @author weigs
 * @date 2017/7/18 0018
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < byteBuffer.limit())
            if (byteBuffer.get() != 0)
                System.out.println("nonzero");
        System.out.println("i = " + i);
        byteBuffer.rewind();
        byteBuffer.asCharBuffer().put("Howdy");
        char c;
        while ((c = byteBuffer.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();
        byteBuffer.rewind();

        byteBuffer.asShortBuffer().put((short) 471142);
        System.out.println(byteBuffer.getInt());
        byteBuffer.rewind();

        byteBuffer.asLongBuffer().put(999343149);
        System.out.println(byteBuffer.getLong());

        byteBuffer.rewind();
        byteBuffer.asFloatBuffer().put(99923333);
        System.out.println(byteBuffer.getFloat());

        byteBuffer.rewind();
        byteBuffer.asDoubleBuffer().put(9924923);

        System.out.println(byteBuffer.getDouble());
        byteBuffer.rewind();
    }
}
