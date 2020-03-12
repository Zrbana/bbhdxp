package java7.daily.learning.prac;

import java.util.Scanner;

/**
 * @ClassName BackMoney
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/12 22:25
 */

//在霍格沃茨找零钱
public class BackMoney {
    private static long toKnut(long galleon, long sickle, long knut) {
        return galleon * 17 * 29 + sickle * 29 + knut;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strP = scanner.next().split("\\.");
        String[] strA = scanner.next().split("\\.");
        // 将字符串转换为数值类型，考虑到可能过大，用 long 类型
        long[] longP = {
                Long.parseLong(strP[0]),
                Long.parseLong(strP[1]),
                Long.parseLong(strP[2]),
        };
        long[] longA = {
                Long.parseLong(strA[0]),
                Long.parseLong(strA[1]),
                Long.parseLong(strA[2]),
        };
        // 将单位全部转换为 纳特(Knut)
        long pInKnut = toKnut(longP[0], longP[1], longP[2]);
        long aInKnut = toKnut(longA[0], longA[1], longA[2]);
        long changeInKnut = aInKnut - pInKnut;
        if (changeInKnut < 0) {
            System.out.print("-");
            changeInKnut = -changeInKnut;
        }
        // 打印时，将单位还原回去
        System.out.format("%d.%d.%d\n",
                changeInKnut / (17 * 29),
                (changeInKnut % (17 * 29)) / 29,
                ((changeInKnut % (17 * 29)) % 29));

    }
}
