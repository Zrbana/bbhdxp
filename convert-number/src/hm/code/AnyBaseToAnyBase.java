package hm.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AnyBaseToAnyBase {

    static final int MINMUM_BASE = 2;
    static final int MAXMUM_BASE = 36;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n;
        int b1,b2;
        while(true){
            System.out.println("Enter number");
            n = in.next();
            System.out.println("Enter begining base(between"+ MINMUM_BASE + " and " + MAXMUM_BASE + "): ");
            b1 = in.nextInt();
            if(b1>MAXMUM_BASE || b1<MINMUM_BASE){
                System.out.println("Invalid base!");
                continue;
            }
            if(!validForBase(n,b1)){
                System.out.println("The number is invalid for this base");
                continue;
            }
            System.out.println("Enter end base(between "+MINMUM_BASE+" and "+MAXMUM_BASE+"):");
            b2= in.nextInt();
            if(b2>MAXMUM_BASE || b2<MINMUM_BASE){
                System.out.println("Invalid base!");
                continue;
            }
            break;
        }
        System.out.println(base2base(n,b1,b2));
    }

    public static boolean validForBase(String n,int base){
        char[] validDigits =  {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        // digitsForBase contains all the valid digits for the base given
        char[] digitsForBase = Arrays.copyOfRange(validDigits, 0, base);

        // Convert character array into set for convenience of contains() method
        HashSet<Character> digitsList = new HashSet<>();
        for (int i = 0; i < digitsForBase.length; i++)
            digitsList.add(digitsForBase[i]);

        // Check that every digit in n is within the list of valid digits for that base.
        for (char c : n.toCharArray())
            if (!digitsList.contains(c))
                return false;

        return true;

    }

    /**
     * 将任何整数从以b1为基底转换为以b2为基底。将b1转换成小数，
     * 小数点后是b2。
     * @param n
     * @param b1
     * @param b2
     * @return
     */
    public static String base2base(String n,int b1,int b2){
        int decimalValue = 0,charB2;
        char charB1;
        String output = "" ;
        for(int i =0;i<n.length();i++){
            // store the character in charB1
            charB1 = n.charAt(i);
            // if it is a non-number, convert it to a decimal value >9 and store it in charB2
            if (charB1 >= 'A' && charB1 <= 'Z')
                charB2 = 10 + (charB1 - 'A');
                // Else, store the integer value in charB2
            else
                charB2 = charB1 - '0';
            // Convert the digit to decimal and add it to the
            // decimalValue of n
            decimalValue = decimalValue * b1 + charB2;

        }
        while (decimalValue != 0) {
            // If the remainder is a digit < 10, simply add it to
            // the left side of the new number.
            if (decimalValue % b2 < 10)
                output = Integer.toString(decimalValue % b2) + output;
                // If the remainder is >= 10, add a character with the
                // corresponding value to the new number. (A = 10, B = 11, C = 12, ...)
            else
                output = (char) ((decimalValue % b2) + 55) + output;
            // Divide by the new base again
            decimalValue /= b2;
        }
        return output;

    }

}













