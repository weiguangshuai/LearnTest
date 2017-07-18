package com.cqupt.text.IO.nio;

import java.nio.*;

/**
 * @author weigs
 * @date 2017/7/18 0018
 */
public class ViewBuffers {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        byteBuffer.rewind();
        System.out.print("Byte Buffer");
        while (byteBuffer.hasRemaining())
            System.out.print(byteBuffer.position() + "->" + byteBuffer.get() + ",");
        System.out.println();

        CharBuffer charBuffer = ((ByteBuffer) byteBuffer.rewind()).asCharBuffer();
        System.out.print("Char Buffer");
        while (charBuffer.hasRemaining())
            System.out.print(charBuffer.position() + "->" + charBuffer.get() + ",");
        System.out.println();

        FloatBuffer floatBuffer = ((ByteBuffer) byteBuffer.rewind()).asFloatBuffer();
        System.out.print("Float Buffer");
        while (floatBuffer.hasRemaining())
            System.out.print(floatBuffer.position() + "->" + floatBuffer.get() + ",");
        System.out.println();

        IntBuffer intBuffer =
                ((ByteBuffer) byteBuffer.rewind()).asIntBuffer();
        System.out.print("Int Buffer");
        while (intBuffer.hasRemaining())
            System.out.print(intBuffer.position() + "->" + intBuffer.get() + ",");
        System.out.println();

        LongBuffer longBuffer = ((ByteBuffer) byteBuffer.rewind()).asLongBuffer();
        System.out.print("Long Buffer");
        while (longBuffer.hasRemaining())
            System.out.print(longBuffer.position() + "->" + longBuffer.get() + ",");
        System.out.println();

    }
}
