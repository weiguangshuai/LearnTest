package com.cqupt.text.Exception;

/**
 * @author weigs
 * @date 2017/5/29 0029
 */
public class LostMessage {
    public void f() throws ImportantException {
        throw new ImportantException();
    }

    public void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
