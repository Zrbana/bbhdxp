package hm.code;

import java.util.Scanner;

/**
 * 将任意的16进制数转换为8进制数
 * 方法：1.将16进制转化成10进制
 *      2.将10进制转换成8进制
 */
public class HexToOct {

    /**
     * 将16进制数转换成10进制数
     * @param s
     * @return
     */
    public static int hexToDecimal(String s){
        String str = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for(int i = 0;i<s.length();i++){
            char a = s.charAt(i);
            int n = str.indexOf(a);
            val  =16*val + n;
        }
        return val;
    }

    /**
     * 将10进制数转成8进制数
     * @param q
     * @return
     */
    public static int decimalToOctal(int q){
        int now;
        int i = 1;
        int octNum = 0;
        while(q>0){
            now = q%8;
            octNum = (now*(int)(Math.pow(10,i)))+octNum;
            q /= 8;
            i++;
        }
        octNum /=10;
        return  octNum;
    }

    public static void main(String[] args) {
        String hexNum;
        int decNum;
        int octalNum;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Hexadecimal Number: ");
        hexNum = sc.nextLine();
        //先转换成10进制
        decNum = hexToDecimal(hexNum);
        //再将十进制转换成8进制
        octalNum = decimalToOctal(decNum);
        System.out.println("Number in octal:"+octalNum);

    }
}
















