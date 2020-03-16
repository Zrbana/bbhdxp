package java7.daily.learning.pract;

/**
 * @ClassName ds
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/16 21:21
 */

import java.util.Scanner;

/**
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 * 【解题思路】：
 * 用max表示经过的数字长度最大值，count表示数字计数器，当为字母时重置为0 end表示数字尾部，每次满
 * 足数字时，对max进行判断，当max小于于count时，更新max和end
 */
public class MaxNumString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int count = 0;
            int max = 0;
            int end = 0;
            String str = scanner.nextLine();
            for(int i = 0;i<str.length();i++){
                char c = str.charAt(i);
                if(c>='0' && c<='9'){
                    count++;
                    if(max<count){
                        max=count;
                        end=1;
                    }
                }else{
                    count=0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }
}
