package java7.daily.learning.pract;

/**
 * @ClassName DeleteSubString
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/16 21:46
 */

/**
 * 链接：https://www.nowcoder.com/questionTerminal/f0db4c36573d459cae44ac90b90c6212
 * 来源：牛客网
 *
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 *
 * 输入描述:
 * 每个测试输入包含2个字符串
 *
 *
 * 输出描述:
 * 输出删除后的字符串
 */

import java.util.Scanner;

/**
 * 【解题思路】：
 * 最简单的思路就是两层循环遍历，下面将“They are students.”称为字符串1，将“aeiou”称为字符串2。每遍
 * 历到字符串2中的一个字符，就在字符串1中找到相同的字符，找到之后删除它，并将字符串1后面的字符整
 * 体向前移动1位。
 */
public class DeleteSubString {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                char[] ch = sc.nextLine().toCharArray();
                String str = sc.nextLine();
                for(int i=0;i<ch.length;i++){
                    if(!str.contains(String.valueOf(ch[i]))){
                        System.out.print(ch[i]);
                    }
                }
            }
        }
}
