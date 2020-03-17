package java7.daily.learning.pract;

import java.util.Scanner;

/**
 * @ClassName IntCount
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/17 23:02
 */

//输入n个整数，输出出现次数大于等于数组长度一半的数。
    //【解题思路】：
//关键方法：
//str.split(" "):按照空格切分字符串
//Integer.valueOf(str):将数字字符串转为int
public class IntCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for(int i = 0;i<arr.length;i++){
                arr[i]= Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for(int j = 1;j< arr.length;j++){
                if(arr[j] == num){
                    count++;
                }else if(count>0){
                    count--;
                }else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
    }
}
