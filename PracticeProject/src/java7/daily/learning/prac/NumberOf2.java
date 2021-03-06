package java7.daily.learning.prac;

/**
 * @ClassName NumberOf2
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/12 22:35
 */


public class NumberOf2 {
    public int countNumberOf2s(int n) {
        int count = 0; // 最终 2 的个数
        int factor = 1; // 从低位到高位计算 2 的个数
        int low = 0; // 屏蔽掉低位
        int current = 0; // 当前计算位数的值
        int high = 0; // 计算高位
        while (n / factor != 0) {
            low = n - (n / factor) * factor;
            current = (n / factor) % 10;
            high = n / (factor * 10);
// 根据当前的
            switch (current) {
                case 0:
                case 1:
                    count += high * factor;
                    break;
                case 2:
                    count += high * factor + low + 1;
                    break;
                default:
                    count += (high + 1) * factor;
                    break;
            }
            factor *= 10;
            return count;
        }
        return 0;
    }
}
