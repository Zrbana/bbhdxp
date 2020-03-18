package java7.daily.learning.pract;

import java.util.Scanner;

/**
 * @ClassName CakeCount
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/18 23:12
 */


public class CakeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int evenICount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
        int oddICount = ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2);
        int ans = m / 4 * (evenICount + oddICount) * 2;
        if (m % 4 > 0) {
            ans += evenICount;
        }
        if (m % 4 > 1) {
            ans += evenICount;
        }
        if (m % 4 > 2) {
            ans += oddICount;
        }
        System.out.println(ans);
    }
}
