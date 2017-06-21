package com.cqupt.text.array;

import com.cqupt.text.generic.Generator;

/**
 * @author weigs
 * @date 2017/6/4 0004
 */
public class CountingGenerator {
    public static class Booleans implements Generator<Boolean> {

        private boolean value = false;

        @Override
        public Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Bytes implements Generator<Byte> {

        private byte value = 0;

        @Override
        public Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefgABCDEFG").toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        int index = 1;
        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class Strings implements Generator<String> {
        private int length = 7;
        Generator<java.lang.Character> cg = new Character();
        public Strings() {}
        public Strings(int length) {
            this.length = length;
        }

        @Override
        public String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new String(buf);
        }
    }
}
