package com.zn;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] arr){
        for(int j = 0;j<arr.length;j++){
            for(int i = 0; i< arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] array  = new int[]{5,4,1,8,6,54,51,0,56,456,12,456,226};
        b.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
