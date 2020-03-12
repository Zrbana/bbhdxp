package java7.daily.learning.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName ReverseStatement
 * @Description 给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出
 * @Author yuisama
 * @Date 2020/3/12 22:43
 */

//按空格分割后，逆序输出即可
public class ReverseStatement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String line = reader.readLine();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.format("%s ", words[words.length - 1 - i]);
        }
        System.out.println(words[0]);
    }
}
