package com.cqupt.text.offer;

/**
 * @author weigs
 * @date 2017/9/6 0006
 */
public class frog {
    public static void main(String[] args) {
        frog f = new frog();
        System.out.println(f.JumpFloorII(3));
    }

    public int JumpFloorII(int target) {
        if (target == 0 || target == 1)
            return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
