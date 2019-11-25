package Simple.daily.practice;

import java.util.Arrays;

//基础版 时间复杂度O(n^2)
public class BubbleSort {
    public int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            for( int j =0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,25,4,1,6};
        BubbleSort b = new BubbleSort();
        b.bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

}
