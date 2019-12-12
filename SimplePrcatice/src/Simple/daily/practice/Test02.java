package Simple.daily.practice;

import java.util.Scanner;

public class Test02 {
    //输入一串字符，以“?”结束。统计其中字母个数，数字个数，其它符号个数
    /**public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input=input.toLowerCase();
        int length = input.length();
        int letters = 0;
        int digits = 0;
        int others = 0;

        for (int i = 0; i < length; i++) {
            char c=input.charAt(i);
            if(c<58&&c>47){
                digits++;
            }else if(c<123&&c>96){
                letters++;
            }else{
                others++;
            }
        }
        System.out.println("Letters="+letters);
        System.out.println("Digits="+digits);
        System.out.println("Others="+(others-1));
    }
     */

/**打印输出一个字符金字塔
      A
     ABA
    ABCBA
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 String str=sc.next();
 int n=(int)str.charAt(0)-64;
 for (int i = 1; i <= n; i++) {
 for (int j = n-1; j >= i; j--) {
 System.out.print(" ");
 }
 int a=0;
 for (int k = 1; k <= 2*i-1; k++) {
 int m=k;
 if(m>=i) {
 m-=a;
 a+=2;
 }
 System.out.print(Character.toUpperCase( (char)(96+m)));
 }
 System.out.println();
 }
 }
 */

/**
 * 约瑟夫环
 * public static void main(String[] args) {
 *         Scanner s = new Scanner(System.in);
 *         int a = s.nextInt();
 *         int b = s.nextInt();
 *         int c = s.nextInt();
 *         ArrayList list = new ArrayList();
 *         for (int i = 0; i < a; i++) {
 *             list.add(i);
 *         }
 *         for (int i = b; list.size()!=1; ) {
 *             i = i+c-1;
 *             if (i >= list.size())
 *                 i = i%list.size();
 *             list.remove(i);
 *         }
 *         System.out.println(list.get(0));
 *     }
 */


/**
 * 打印质数表
 *  public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int n=sc.nextInt();
 *         for (int i = 1; i <= n; i++) {
 *             if(i!=1) {
 *                 int j=2;
 *                 while (i%j!=0) {
 *                     j++;
 *                 }
 *                 if(i==j)System.out.print(i+" ");
 *             }
 *         }
 *     }
 */

/**
 * 扫雷
 *  public static void main(String[] args) {
 *         Scanner s = new Scanner(System.in);
 *         int a = s.nextInt();
 *         int b = s.nextInt();
 *         int l[] = {-1,-1,-1,0,0,1,1,1};
 *         int m[] = {-1,0,1,-1,1,-1,0,1};
 *         char c[][] = new char[a][b];
 *         for(int i=0;i<a;i++) {
 *             String d=s.next();
 *             for(int j=0;j<d.length();j++) {
 *                 c[i][j]=d.charAt(j);
 *             }
 *         }
 *         for (int i = 0; i < a; i++) {
 *             for (int j = 0; j < b; j++) {
 *                 if (c[i][j] == '*') {
 *                     for (int k = 0; k < 8; k++) {
 *                         if (jia(i + l[k], j + m[k], c) && c[i + l[k]][j + m[k]] != '*'){
 *                             c[i + l[k]][j + m[k]] = c[i + l[k]][j + m[k]] == '?' ? '1' : (char) (c[i + l[k]][j + m[k]] + 1);
 *                         }
 *                     }
 *                 }
 *             }
 *         }
 *         for (int i = 0; i < c.length; i++) {
 *             for (int j = 0; j < c[i].length; j++) {
 *                 if (c[i][j] == '?')
 *                     System.out.print(0);
 *                 else
 *                     System.out.print(c[i][j]);
 *             }
 *             System.out.println();
 *         }
 *     }
 *     public static boolean jia(int b, int c, char[][] a){
 *         if (b>=0 && b<a.length && c>=0 && c<a[b].length)
 *             return true;
 *         return false;
 *     }
 */


/**
 * 蛇形矩阵
 *  public static void main(String[] args) {
 *         Scanner s = new Scanner(System.in);
 *         int a = s.nextInt();
 *         int b[][] = new int[a][a];
 *         b[0][0] = 1;
 *         int f = 1;
 *         int i=0,j=0;
 *         for (int k = 1; k < a*a; k++) {
 *             switch (f){
 *                 case 1:
 *                     if (j == a-1){
 *                         i++;b[i][j] = k+1;f=2;
 *                     }
 *                     else {
 *                         j++;b[i][j] = k+1;f=2;
 *                     }
 *                     break;
 *                 case 2:
 *                     j--;i++;
 *                     b[i][j] = k+1;
 *                     if (j==0 || i==a-1){
 *                         f=3;
 *                     }
 *                     break;
 *                 case 3:
 *                     if (i == a-1){
 *                         j++;b[i][j] = k+1;f=4;
 *                     }
 *                     else {
 *                         i++;b[i][j] = k+1;f=4;
 *                     }
 *                     break;
 *                 case 4:
 *                     i--;j++;
 *                     b[i][j] = k+1;
 *                     if (i==0 || j==a-1){
 *                         f=1;
 *                     }
 *                     break;
 *
 *             }
 *
 *
 *         }
 *         for (int l = 0; l < a; l++) {
 *             for (int m = 0; m < a; m++) {
 *                 System.out.print(b[l][m]+" ");
 *             }
 *             System.out.println();
 *         }
 *     }
 */
}
