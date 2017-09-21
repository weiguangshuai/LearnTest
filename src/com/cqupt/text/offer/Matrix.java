package com.cqupt.text.offer;

/**
 * @author weigs
 * @date 2017/9/8 0008
 */
public class Matrix {
    public static void main(String[] args) {
        Matrix m = new Matrix();
        System.out.println(m.RectCover(8));
    }

    private int RectCover(int target) {
        if (target <= 1) {
            return 1;
        } else if (target * 2 == 2) {
            return 1;
        } else if (target * 2 == 4) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }

    }
}
