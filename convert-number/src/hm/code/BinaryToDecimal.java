package hm.code;

import java.util.Scanner;

/**
 * 将二进制转换成10进制
 */
public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binNum,binCopy;
        int d=0;
        int s=0;
        int power = 0;
        System.out.println("Binary number:");
        binNum = sc.nextInt();
        binCopy = binNum;
        while ((binCopy != 0)) {
            d = binCopy %10;
            s+=d*(int)Math.pow(2,power++);
            binCopy /=10;
        }
        System.out.println("Decimal Number:"+s);
        sc.close();
    }


}

