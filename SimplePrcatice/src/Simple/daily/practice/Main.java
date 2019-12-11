package Simple.daily.practice;

import java.util.Scanner;

public class Main {
    //斐波那契数列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = 0, b = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                c = a = 0;
            } else if (i == 2) {
                c = b = 1;
            } else {
                c = a + b;
                a = b;
                b = c;
            }
        }
        System.out.println(c);
    }


}
    /**
    public static void main(String[] args) {
        //乘法口诀表
        for(int i = 1;i <=9;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(j+"*"+i+"="+(j*i<10?" "+j*i+" ":j*i+" "));

            }
            System.out.println(" ");
        }
    }
}
    //数位之和
    //方法一：把输入当做字符串处理，charAt()方法可以返回下标位置所对应的字符
    /**public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int sum = 0;
        for(int i= 0;i<n.length();i++){
            sum+=n.charAt(i)-'0';
        }
        System.out.println(sum);

    }
}
    /**
    public static void main(String[] args) {
        int a=0;
        int b=0;
        int c=0;
        int sum=0;//总数
        int illegal=0;
        Scanner in = new Scanner(System.in);
        while(!in.hasNext("-1")){
            int n = in.nextInt();
            if(n==1){
                a++;
                sum++;
            }else if(n==2){
                b++;
                sum++;
            }else if(n==3){
                c++;
                sum++;
            }else{
                illegal++;
            }
        }
        System.out.println("A"+"="+a);
        System.out.println("B"+"="+b);
        System.out.println("C"+"="+c);
        System.out.println("Tot"+"="+sum);
        int mid = (illegal+sum)/2;
        if(a>mid){
            System.out.println("A-yes");
        }else if(b>mid){
            System.out.println("B-yes");
        }else if(c>mid){
            System.out.println("C-yes");
        }else{
            System.out.println("all-NO");
        }

    }

}
    //求自然数N的所有约数之和
   /** public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum= 0;
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
    */

        //编程找出小于n的四位数ABCD中满足下述关系的数：
        //
        //（ＡＢ＋ＣＤ）∗（ＡＢ＋ＣＤ）＝ＡＢＣＤ
        /**Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            int d = i % 10;
            int c = i / 10 % 10;
            int b = i / 100 % 10;
            int a = i / 1000;
            int sum = a * 10 + b + c * 10 + d;
            if (sum * sum == i) {
                System.out.println(i);
            }
        }
    }
}
         */
    /**
     * public static void main(String[] args) {

            Scanner input  = new Scanner(System.in);
            int n = input.nextInt();
            double sum=0;
            int a=0;
            for(int i =1;i<=n;i++){

                sum+=1.0/i;
            }
            System.out.printf("%.6f",sum);

            */



