package www.cases;

import www.annotation.Benchmark;
import www.annotation.Case;
import www.annotation.Measurement;
import www.utils.GreateArr;

@Measurement(iterations = 10,group = 5)
public class SortCase implements Case {
    static int[] arr = GreateArr.arrRandom;

    public static void main(String[] args) {
        quickSortInternal(arr, 0 ,arr.length-1);
        for(int x:arr) {
            System.out.print(x+" ");
        }
    }


    @Benchmark
    public void quickSort_3() {
        quickSortInternal(arr, 0 ,arr.length-1);
    }

    public static void quickSortInternal(int[] array, int low, int high) {
        if(low >= high) {
            return;
        }
        if(high-low+1 <= 10) {
            //直接插入排序
            insertSort(array, low, high);
            return;
        }
        int[] bounds = partition(array, low, high);
        //[low ,bounds[0]) 代表比基准值低的区间，
        // [bounds[0] , bounds[1]) 代表等于基准值的区间，
        // [bounds[1] , high] 代表大于基准值的区间
        quickSortInternal(array, low, bounds[0]-1);
        quickSortInternal(array, bounds[1], high);

    }

    public static int[] partition(int[] array, int low, int high) {
        //-----------------------------------------------
        // |  <temp  | ==temp | ?待遍历 | >temp  |
        //-----------------------------------------------
        // low      less     k         great      high
        int k = low;
        int less = low;
        int great = high;
        int temp = array[high];
        //这里必须是 < ,不能是<=;
        while(k < great) {
            if(array[k] == temp) {
                k++;
            }else if(array[k] < temp) {
                swap(array, k, less);
                less++;
                k++;
            }else {
                while(k < great && array[great] > temp) {
                    great--;
                }
                swap(array, great, k);
            }
        }
        return new int[] {less, great};
    }
    public static void swap(int array[], int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
    //直接插入排序
    public static void insertSort(int[] arr, int low, int high) {
        for(int i =low+1; i<=high; i++) {
            int temp = arr[i];
            int j;
            for(j=i-1; j>=low; j--) {
                if(temp < arr[j]) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
}
