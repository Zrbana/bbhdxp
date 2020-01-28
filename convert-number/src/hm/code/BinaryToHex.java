package hm.code;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 二进制转十六进制
 */
public class BinaryToHex {


    public static String binToHext(int binary){
        //存储十六进制代码范围内的二进制数字:0000到1111即十进制数字0到15
        HashMap<Integer,String> hm = new HashMap<>();
        String hex = "";
        int i ;
        for(i=0;i<10;i++){
            hm.put(i,String.valueOf(i));
        }
        for(i=10;i<16;i++) {
            hm.put(i, String.valueOf((char) ('A' + i - 10)));
        }
            int currbit;
        while (binary != 0) {
            int code4 = 0;
            for (i = 0; i < 4; i++) {
                currbit = binary % 10;
                binary = binary / 10;
                code4 += currbit * Math.pow(2, i);
            }
            hex = hm.get(code4) + hex;
        }
        return hex;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary number:");
        int binary = sc.nextInt();
        String hex = binToHext(binary);
        System.out.println("Hexadecimal Code:" + hex);
        sc.close();
    }
}
