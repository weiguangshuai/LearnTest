package com.cqupt.text.algorithms;

/**
 * 动态规划相关算法
 *
 * @author weigs
 * @date 2017/8/14 0014
 */
public class DynamicProgram {

    public static void main(String[] args) {
        int[][] map = {{1, 2, 3, 4, 5, 6}, {2, 3, 5, 6, 3, 1},
                {1, 3, 5, 7, 4, 2}};
        DynamicProgram dynamicProgram = new DynamicProgram();
        System.out.println(dynamicProgram.getMin(map, 3, 6));
        int[][] map2 = {{1, 2, 3}, {1, 1, 1}};
        System.out.println(dynamicProgram.getMin(map2, 2, 3));

        System.out.println(dynamicProgram.countWays(10));

        System.out.println(dynamicProgram
                .findLCS("fadfda2erefs", 12, "fasfas", 6));
    }

    //走方格问题
    public int getMin(int[][] map, int n, int m) {
        //dp表示在nm位置时的路径长度
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][0] += map[j][0];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                dp[0][i] += map[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = min(dp[i][j - 1] + map[i][j],
                        dp[i - 1][j] + map[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

    public int min(int a, int b) {
        if (a > b) {
            return b;
        } else
            return a;
    }


    //有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
    //给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000
    public int countWays(int n) {
        if (n <= 2) {
            return n;
        }
        int f = 1;
        int s = 2;
        int t = 0;
        for (int i = 3; i <= n; i++) {
            t = (f + s) % 1000000007;
            f = s;
            s = t;
        }
        return t;
    }

    //最长公共序列数
    public int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n][m];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = 1;
                for (int j = i + 1; j < n; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (a[0] == b[i]) {
                dp[0][i] = 1;
                for (int j = i + 1; j > m; j++) {
                    dp[0][j] = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j > m; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];

    }

    public int max(int a, int b, int c) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        return max;
    }
}
