package java7.daily.learning.prac;

import java.util.Scanner;

/**
 * @ClassName Plalindrome
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/15 21:19
 */

//判断插入后构成回文的方法数
public class Plalindrome {


    /**
     * 判断字符串是否是回文
     * 将字符串转成字符，一个指针从前往后遍历，一个指针从后往前遍历，不相等则不是回文串
     * @param str
     * @return
     */
    public static boolean isPlalinedrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        //将给定字符串依次插入
        Scanner sc = new Scanner(System.in);
        String strA = sc.next();
        String strB = sc.next();
        int count=0;
        for(int i = 0;i<strA.length();i++){
            StringBuilder sb = new StringBuilder(strA);
            sb.insert(i,strB);
            if(isPlalinedrome(strA.toString())){
                count++;
            }
        }
        System.out.println(count);
    }

}
