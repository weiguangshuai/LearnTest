package com.cqupt.text.exp;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/6/5 0005
 */
public class Game {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int integer_from_keyboard;
        int one_larger_integer;

        System.out.print(
                "\n This program is a computer game. Please, type in "
                        + "\n an integer in the range  1 ... 2147483646 : ");

        integer_from_keyboard = keyboard.nextInt();

//        one_larger_integer  =  integer_from_keyboard  +  1 ;

        int largerInteger = integer_from_keyboard * 2;
        System.out.print("\n You typed in " + integer_from_keyboard + "."
                + "\n My number are " + largerInteger + "," +
                (largerInteger + 1) + "," + (largerInteger + 2) + "."
                + "\n Sorry, you lost. I won. The game is over.\n");

        integer_from_keyboard = keyboard.nextInt();

//        one_larger_integer  =  integer_from_keyboard  +  1 ;

        int smallInteger = integer_from_keyboard / 2;
        System.out.print("\n You typed in " + integer_from_keyboard + "."
                + "\n My number are " + smallInteger + "," +
                (smallInteger + 1) + "," + (smallInteger + 2) + "."
                + "\n Sorry, you lost. you won. The game is over.\n");
    }
}
