package java7.daily.learning.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName IndexCount
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/14 22:42
 */

//输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）
    //通过Arrays的方法可以快速找到对应的元素的下标
public class IndexCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums =  sc.nextLine().split(" ");
        String x = sc.nextLine();
        System.out.println(Arrays.asList(nums).indexOf(x));
    }
}
