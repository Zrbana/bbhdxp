package Simple.daily.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 设置有序区边界
 */
public class BubbleSort_02 {

    public int[] bubble(int[] arr){
        int lastExchange = 0;//最后一次比较的位置
        int sortBoder = arr.length-1;//无序边界位置，每次比较到这里就可以了
        for(int i = 0;i<arr.length;i++){
            boolean isSorted = false;
            for(int j =0;j<sortBoder;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSorted = false;
                    lastExchange = j;//找到无序边界位置
                }
            }
            sortBoder = lastExchange;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,48,56,21,48,54,12};
        int[] arr1 = new int[]{1,24,85,12,5,6,48};

        BubbleSort_02 bubble =  new BubbleSort_02();
        bubble.bubble(arr);
        bubble.bubble(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
