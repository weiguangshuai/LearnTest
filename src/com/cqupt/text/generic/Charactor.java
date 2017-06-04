package com.cqupt.text.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weigs
 * @date 2017/6/1 0001
 */
public class Charactor {
}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class GenericsAndCovariance {
    public static void main(String[] args) {

    }
}