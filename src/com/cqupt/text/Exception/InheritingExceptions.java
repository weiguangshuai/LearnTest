package com.cqupt.text.Exception;

/**
 * @author weigs
 * @date 2017/5/29 0029
 */
public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException From f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            /*
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
            */

//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
