package java7.daily.learning.prac;

/**
 * @ClassName Finder
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/15 21:35
 */

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e016ad9b7f0b45048c58a9f27ba618bf
 * 来源：牛客网
 *
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */
public class Finder {
    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n-1, K);
    }
    public int findKth(int[] a, int low, int high, int k) {
        int part = partation(a, low, high);
        if(k == part - low + 1){
            return a[part];
        }
        else if(k > part - low + 1) {
            return findKth(a, part + 1, high, k - part + low -1);
        }
        else {
            return findKth(a, low, part -1, k);
        }
    }
    public int partation(int[] a, int low, int high) {
        int key = a[low];
        while(low < high) {
            while(low < high && a[high] <= key) {
                high--;
            }
            a[low] = a[high];
            while(low < high && a[low] >= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
}
