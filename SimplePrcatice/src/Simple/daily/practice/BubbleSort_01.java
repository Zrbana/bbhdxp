package Simple.daily.practice;

import java.util.Arrays;

/**
 * 设置标志位，当数组已经有序后，退出循环
 *  时间复杂度O(n^2)
 */
public class BubbleSort_01 {
    public int[] bubble(int[] arr){
        for(int i =0;i<arr.length;i++){
            boolean isSorted = true;//设置有序标志位
            for(int j =0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSorted = false;//仍有元素交换，证明无序
                }
            }
            if(isSorted){
                break;//数组已经有序，跳出循环
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,48,56,21,48,54,12};
        int[] arr1 = new int[]{1,24,85,12,5,6,48};

        BubbleSort_01 bubble =  new BubbleSort_01();
        bubble.bubble(arr);
        bubble.bubble(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
