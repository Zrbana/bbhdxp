package Simple.daily.practice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**1.	根据天数（46）计算周数和剩余的天数
public class Test01 {
    public void weeks(int x){
        int y = x/7;
        int z=x%7;
        System.out.println("周数为："+y+",剩余的天数为"+z);
    }

    public static void main(String[] args) {
        Test01 t1 = new Test01();
        t1.weeks(46);
    }

}
*/

/**4.	任意输入三个数，然后按从大到小的顺序输出
public class Test01{

    public static void max(int x, int y,int z){
        if(x>y){
            int temp=x;
            x=y;
            y=temp;
        }
        if(x>z){
            int temp=x;
            x=z;
            z=temp;
        }
        if(y>z){
            int temp=y;
            y=z;
            z=temp;
        }
        System.out.println(x+","+y+","+z);
    }

    public static void main(String[] args) {
        System.out.println("请输入三个数：");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        Test01 t1= new Test01();
        t1.max(x,y,z);

    }
}
*/





/**5.	用if…else if语句判断闰年问题
public class Test01{
    public static void main(String[] args) {
        System.out.println("请输入一个年份，判断是否为闰年：");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        Test01 t1= new Test01();
        System.out.println("判断结果："+t1.leap_year(x));
    }
    public boolean leap_year(int i ){
        if(i%4==0 && i%100!=0)
            return true;
        else if(i%400==0)
            return true;
        else
            return false;
    }
}
 */

/**6.	要求输入一个代表年月日的8位整数，计算出其上一天和下一天是什么日期
public class Test01{
    public static void main(String[] args) throws ParseException {
        Test01 test = new Test01();
        System.out.println("2016-10-31的后一天是："+test.getTomorrow("2016-10-31"));
        System.out.println("2019-01-01的前一天是："+test.getYesterday("2019-01-01"));
        System.out.println("2014-03-01的前一天是："+test.getYesterday("2014-03-01"));
    }
    public static String getTomorrow(String strDate) throws ParseException {
           Calendar c = Calendar.getInstance();
           Date date=null;
                  try {
                      date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

                  } catch (ParseException e) {
                      e.printStackTrace();
                  }
                  c.setTime(date);
                 int day=c.get(Calendar.DATE);
                 c.set(Calendar.DATE,day+1);
                 String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                 return dayAfter;
    }
    public static String getYesterday(String strDate){
             Calendar c = Calendar.getInstance();
             Date date=null;
             try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
              } catch (ParseException e) {
                   e.printStackTrace();
             }
            c.setTime(date);
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day-1);

            String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            return dayBefore;
 }
}
*/
/**7.	已知2019年3月17日是星期日,求出用户输入一个代表年月日的8位整数是星期几
public class Test01{
    public static void main(String[] args) throws Exception {
        String str = "2014/11/17";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.setTime(sdf.parse(str));
        int i =calendar.get(Calendar.DAY_OF_WEEK);
        if(i == 1){
            System.out.println("今天是星期日");
        }else{
            System.out.println("今天是星期"+(i-1));
        }

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss E");
        System.out.println(sdf1.format(calendar.getTime()));

        SimpleDateFormat sdf2 = new SimpleDateFormat("E");
        System.out.println(sdf2.format(calendar.getTime()));
    }
}
 */
/**8.	求出100以内所有偶数的和
public class Test01{
    int sum=0;
    public void add() {

        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("100以内所有偶数的和是：" + sum);
    }
    public static void main(String[] args) {
        Test01 t1= new Test01();
        t1.add();
    }
}

 */
//        10.	缸子里一共有50升水。现有15升。每次能挑5升。要挑几次才能挑满。



/**       11.	求出1!+2!+...+n!是多少？（使用while来做）
public class Test01{
    public static void main(String[] args) {
        int i=1;
        double sum1 =1;
        double sum2 =0;
        while(i<=10)
        {
            sum1 = sum1 * i;
            sum2 = sum2 + sum1;
            i++;
        }
        System.out.println("10的阶乘之和是："+sum2);
    }
}
 */
/**    12.	用while循环方式做一个图形！直角三角形！
 public class Test01{
    public static void main(String[] args) {
        int i,j;
        i=1;
        while (i<=10) {
            j=1;
            while (j<=i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
 */
/**        13.	要求用户输入一个数，使用do-while将它反转过去！
public class Test01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num=sc.nextInt();
        int result=0;//存反转的数字
        while(true)
        {
            int n=num%10;//取出最低位上的数字
            result=result*10+n;//依次的反转存储得到反转的数字
            num=num/10;//降位
            if(num==0)
            {
                break;
            }
        }
        System.out.println(result);

    }
}  14.	打印出九九乘法表

/**        15.	求出1000以内所有能被4和5整除并且不能被3整除的数之和
public class Test01{
    public static void main(String[] args) {
        for(int i = 1;i<=9;i++){
            for(int j =1;j<=i;j++){
                int k = i*j;
                System.out.print(j+"*"+i+"="+k+"\t");;
            }
            System.out.println();
        }
    }
}

//        16.	有一个猜数字游戏，系统随机生成一个数用户来猜，每人有10次机会。
/** 当用户猜完之后统计用户得分情况（猜对一次给1分，猜错不得分）
public class Test01{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int trueNumber = (int)(Math.random()*10+1);//0-100的随机数
        int i =1;
        while(i<=10){
            System.out.println("请输入数字：");
            if(x==trueNumber){
                System.out.println("恭喜你，猜对了！");
                break;
            }else if(x>trueNumber){
                System.out.println("很遗憾，猜大了！你还有"+(10-i)+"次机会");
            }else if(x<trueNumber){
                System.out.println("很遗憾，猜大了！你还有"+(10-i)+"次机会");
            }
            i++;
        }
    }
    public void game() {
    }
}
 */
// 每一个档次的分数所给出的提示不同。（要求当用户连续输入三次错误的时候直接退出并给出评价）




//        17.	1~10之间的整数相加，得到累加值大于20的当前数.

/**
 斐波那契数列
public class Test01{
    public int Fun(int n) {
        while (n <= 39) {
            if (n == 1 || n == 2) {
                return 1;
            }
            return Fun(n - 1) + Fun(n - 2);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Test01 test = new Test01();

        System.out.println("jeiguo"+test.Fun(n));
    }
}
*/



/**    18.	求出1000以内所有能被9整除的数之和，每行显示5个数
public class Test01{
    public static void main(String[] args) {
        int a=1;
        int sum=0;
        int n =0;
        for(n =0;n<1000;n++)
        {
            if(n%9==0)
            {
                System.out.print(n+"\t");
                if(a%5==0)
                {
                    System.out.println();
                }
                a++;
            }
        }
        sum+=n;
        System.out.println("1000以内所有能被9整除的数之和:"+sum);
    }
}
 */

/**       19.	求出10的N次方的值，N为用户输入的
public class Test01{
    public static void main(String[] args) {
        System.out.println("请输入N:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("10的"+n+"次方的值为："+pow(10,n));
    }
}
*/
//        20.	循环打印出26个英文字母，并按照通用排列表排列（提示a是97，显示出来4行，每行显示6到7个）
//        21.	使用for循环求出第一个数+第二个数=第三个数 依此类推的 要求循环的次数是用户界面输入的（初始定义第一个数为1，第二个数为1）
/**       然后打印出这个数列（斐波那契数）
public class Test01{
    public static void main(String[] args) {
        fibonaccl(10);
    }

    static void fibonaccl(int n) {

        if(n <= 0) {
            System.out.println("输入的n值错误！");
            return;
        }
        int f = 1;
        int k = f;
        int temp;
        System.out.print("斐波那契数列为：");
        for(int i = 1 ; i < n ; i++) {
            if(i < 2) {
                System.out.print(k + " ");
            }else {
                System.out.print(k + " ");
                temp = k + f;
                f = k;
                k = temp;
            }

        }
        System.out.print(k);
        System.out.println();
        System.out.println(n + "对应的是：" +k);
    }

}
//        22.	打印出这样的效果图：
//          *
//	       * * *
//	      * * * * *
/**	    * * * * * * *
public class Test01{
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 5 - i; j++)
                System.out.print(" ");
            for (j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
 */
/**        23.	用户输入一个数，判断这个数是否是素数
public class Test01{
    public static void main(String[] args) {
            int a;
            System.out.println("请输入一个正整数:");
            Scanner sc=new Scanner(System.in);
            a=sc.nextInt();
            if(judge(a))
                System.out.println("该正整数是素数");
            else
                System.out.println("该正整数不是素数");
        }
    public static boolean judge(int a){
        int i,b=(int)Math.sqrt(a);
        for(i=2;i<=b;i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
}
*/
/**9.	输出100以内能被7整除的前5个数
public class Test01{
    public void inputNumber(){
        int count =0;
        for(int i=0;i<=100;i++){
            if(i%7==0){
                System.out.println(i);
                count++;
            }
            if(count==5)
                break;
        }

    }

    public static void main(String[] args) {
        Test01 t1= new Test01();
        t1.inputNumber();
    }
}
*/
/**17.	1~10之间的整数相加，得到累加值大于20的当前数.
public class Test01{
    public static void main(String[] args) {
        int num = 0;
        for (int i =1;i<10;i++) {
            num += i;
            if (num > 20) {
                System.out.println(num);
                break;
            }
        }
    }
}
*/
public class Test01{
    public static void main(String[] args) {
        int a=1;
        for(char i=0;i<128;i++){
            if(Character.isLowerCase(i)){
                System.out.print(i+"\t");
                if(a%5==0){
                    System.out.println();
                }
                a++;
            }

        }
    }
}
//20.	循环打印出26个英文字母，并按照通用排列表排列（提示a是97，显示出来4行，每行显示6到7个）
//16.	有一个猜数字游戏，系统随机生成一个数用户来猜，每人有10次机会。
// 当用户猜完之后统计用户得分情况（猜对一次给1分，猜错不得分），
/** 每一个档次的分数所给出的提示不同。（要求当用户连续输入三次错误的时候直接退出并给出评价）
public class Test01 {
    public static void main(String[] args) {
        Test01 test = new Test01();
        test.game();
    }

    public void game() {
        int i = 1;
        int count =0;
        System.out.println("欢迎来到猜数字游戏！");
        System.out.println("每轮游戏你有十次机会！");
        while (i <= 10) {

            System.out.println("请输入一个数字开始游戏：");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int trueNumber = (int) (Math.random() * 100);
            if (n == trueNumber) {
                System.out.println("恭喜你，猜对了！");
                count++;
                break;
            } else if (n > trueNumber) {
                System.out.println("很遗憾，猜大了！");
                System.out.println("你还有" + (10 - i) + "次机会！");
            } else if (n < trueNumber) {
                System.out.println("很遗憾，猜小了！");
                System.out.println("你还有" + (10 - i) + "次机会！");
            }
            i++;
        }
        System.out.println("得分为："+count);
    }
}
*/



