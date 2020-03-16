package java7.daily.learning.pract;

/**
 * @ClassName BuyApple
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/16 21:43
 */

/**
 * 链接：https://www.nowcoder.com/questionTerminal/61cfbb2e62104bc8aa3da5d44d38a6ef
 * 来源：牛客网
 *
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 */

import java.util.Scanner;

/**
 * 【解题思路】：
 * 对数字特征进行分析。 首先，6和8都是偶数。因此，能凑出的个数也一定是偶数。程序中若苹果总数是奇
 * 数，可以直接返回-1。 再次，偶数个苹果数对8取模，其结果只可能为0,2,4,6。若余数为6或者0，则可以直
 * 接用6包装情况处理，不需要回溯购买8包装的情况。若余数为4，只需回溯1次即可，因为8+4=12, 12%6 =
 * 0。若余数为2，只需回溯2次即可，因为8+8+2=18, 18%6 = 0。 综上，可以采用如下思路进行处理。（由于
 * 数字6和8的特征，本方法只适用于本题） 情况1：若num不是偶数，则直接返回-1 情况2：若num%8 = 0，
 * 则返回num/8 情况3：若num%8 != 0，则只需回溯1次或者2次8包装购买个数，就可以求解。回溯1次，其
 * 结果为n/8-1+2 = n/8+1；回溯1次，其结果为n/8-2+3 = n/8+1。因此，可以情况3下，可以返回n/8+1
 */
public class BuyApple {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            System.out.println(count(n));
        }
    }
    public static int count(int n){
//一定是偶数（6，8都是）,最小是6，10以上偶数都可以；
        if(n%2!=0||n==10||n<6) {
            return -1;
        }
//如果拿八个拿完最好
        if(n%8==0) {
            return n / 8;
        }
//对于10以上的偶数，只要对8取余数不为0，就要从前面的1或者2个8中拿出2个，把余数补为6（本来余
       // 数就是6，就不用拿）。所以+1；
        return 1+n/8;
    }
}
