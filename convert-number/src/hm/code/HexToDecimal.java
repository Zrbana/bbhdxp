package hm.code;

import java.util.Scanner;

/**
 * 将16进制转换成10进制
 */
public class HexToDecimal {

    public static int hexToDec(String hex){
        String str = "0123456789ABCDEF";
        hex = hex.toUpperCase();

        int val = 0;
        for(int i = 0;i<hex.length();i++){
            int d= str.indexOf(hex.charAt(i));
            val = 16*val + d;
        }
        return val;
    }

    public static void main(String args[]) {
        String hexa_Input;
        int dec_output;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Hexadecimal Number : ");
        hexa_Input = scan.nextLine();


        dec_output =hexToDec(hexa_Input);
        System.out.println("Number in Decimal: " + dec_output);


    }
}

