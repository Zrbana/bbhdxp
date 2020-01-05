package test.frame.cases;

import test.frame.annotation.Case;
import test.frame.annotation.MeasureMent;
import test.frame.utils.GreateArr;

@MeasureMent(iterations = 10,group = 5)
public class quickSortCase implements Case {
    static int[] arr = GreateArr.arrRandom;

    //@Benchmark
    public void quick_1() {
        quickSort(arr);
    }
    public static void quickSort(int[] arr) {
        int length = arr.length;
        if(length <= 1) {
            return;
        }
        quickSortInternal(arr,0,length-1);
    }
    private static void quickSortInternal(int[] arr, int l, int r) {
        if(l >= r) {
            return;
        }
        //获取基准值
        int par = patition(arr, l, r);
        quickSortInternal(arr, l, par-1);
        quickSortInternal(arr, par+1, r);
    }
    private static int patition(int[] arr, int l, int r) {
        //takeThreeNumber(arr, l, r);
        int val = arr[l];
        //[l+1, j]区间内都是小于val
        int j = l;
        //[j+1, i]区间内都是大于等于val
        int i = l+1;
        for(; i<=r;i++) {
            if(arr[i] < val) {
                swap(arr, i, j+1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void takeThreeNumber(int[] arr, int low, int high) {
        int mid = (low+high)>>>1;  //无符号右移
        if(arr[mid] > arr[low]) {
            swap(arr, mid, low);
        }
        if(arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        if(arr[low] > arr[high]) {
            swap(arr, low, high);
        }
    }
}
