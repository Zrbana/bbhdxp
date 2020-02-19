package com.zn;

import java.util.Arrays;

public class InsertSort {

    //直接插入
    public static void insert_01( int arr[]){
        for(int i = 1;i<arr.length;i++){
            int temp = arr[i];
            int j;
            for(j=i-1;j>=0 && temp<arr[j];j--){
                arr[j+1]  = arr[j];//将较大的向后移动一个位置
            }
            arr[j+1]  =temp;
        }
    }

    //二分插入排序
    public static void insert_02(int arr[]){
        for(int i= 1;i<arr.length;i++){
            int left = 0;
            int right = i-1;
            int temp = arr[i];
            while(left<=right){
                int mid = (left+right)/2;
                if(temp>arr[mid]){
                    left = mid+1;//向右缩小范围
                }else{
                    right = mid-1;//向左缩小范围
                }
            }
            for(int j =i-1;j>=left;j--){
                arr[j+1] = arr[j];
                arr[left] = temp;
            }
        }
    }

    //希尔排序：缩小增量排序
    //基本思想：分组的直接插入排序
    public static void shellSort(int arr[]){

        //增量d控制扫描趟数
        for (int d= arr.length/2;d>0;d=d/2){
            for(int i = d;i<arr.length;i++){
                int temp = arr[i];
                int j;
                for(j = i-d;j>=0&&temp<arr[j];j = j-d){
                    arr[j+d] = arr[j];
                }
                arr[j+d]  =temp;
            }
        }
    }


    public static void main(String[] args) {

        int[] array  = new int[]{5,4,1,8,6,54,51,0,56,456,12,456,226};
        InsertSort.insert_01(array);
        InsertSort.insert_02(array);
        InsertSort.shellSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
    }
}
