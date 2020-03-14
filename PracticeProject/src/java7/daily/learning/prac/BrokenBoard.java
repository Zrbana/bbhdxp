package java7.daily.learning.prac;

/**
 * @ClassName BrokenBoard
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/14 22:27
 */

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 方法：比较两个字符串的不同点
 */
public class BrokenBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalString = scanner.next();//给定的字符串
        String typedOutString = scanner.next();
        ArrayList<Character> wornOutKeys = new ArrayList<>();

        int size = originalString.length();
        int iOriginal = 0;
        int iTypedOut = 0;
        while (iOriginal < size) {
            boolean wornOut = false;//假设没有损坏
            char originalCh = originalString.charAt(iOriginal);

            char originalUpper = Character.toUpperCase(originalCh); // 全部大写
            if (iTypedOut >= typedOutString.length()) {
// 输出的字符串已经结束了
                wornOut = true;
            } else {
                char typedOutCh = typedOutString.charAt(iTypedOut);
                char typedOutUpper = Character.toUpperCase(typedOutCh);
                if (originalUpper != typedOutUpper) {
// 应该看到输出的字符没有输出
                    wornOut = true;
                }
            }
            if (wornOut) {
                if (!wornOutKeys.contains(originalUpper)) {
                    wornOutKeys.add(originalUpper);
                }
                iOriginal++;
            } else {
                iOriginal++;
                iTypedOut++;
            }
        }
    }
}
