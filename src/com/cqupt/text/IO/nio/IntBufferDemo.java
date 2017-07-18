package com.cqupt.text.IO.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 试图缓存器
 *
 * @author weigs
 * @date 2017/7/18 0018
 */
public class IntBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();

        intBuffer.put(new int[]{11, 233, 21, 3232, 12, 34, 12, 21, 45, 76, 87, 54});
        System.out.println(intBuffer.get(3));
        intBuffer.put(3, 1811);
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }

    }
}
