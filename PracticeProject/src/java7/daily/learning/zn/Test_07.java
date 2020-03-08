package java7.daily.learning.zn;

import java.util.Scanner;

/**
 * @ClassName Test_07
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/8 22:557
 */


public class Test_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// 数组长度为n表示n个数字
        int sum = scanner.nextInt();// 部分元素求和sum
        int[] value = new int[n];//初始化数组
        long[] dp = new long[sum + 1];//动态规划数组
        dp[0] = 1;//index=0的初始化值
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
            for (int j = sum; j >= 0; j--) {
                if (j >= value[i]) {
                    dp[j] += dp[j - value[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
