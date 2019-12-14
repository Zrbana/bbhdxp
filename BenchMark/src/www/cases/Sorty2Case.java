package www.cases;

import www.annotation.Case;
import www.annotation.Measurement;
import www.utils.GreateArr;

@Measurement(iterations = 10,group = 5)
public class Sorty2Case implements Case {
    static int[] arr = GreateArr.arrRandom;

    public static void main(String[] args) {
        quickSort(arr, 0 ,arr.length-1);
        for(int x:arr) {
            System.out.print(x+" ");
        }
    }

    //@Benchmark
    public void quickSort() {
        quick(arr);
    }

    public static void quick(int[] arr) {
        if(arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
//        if(high-low+1 <= 100) {
//            //直接插入排序
//            insertSort(arr, low, high);
//            return;
//        }
        //takeThreeNumber(arr, low, high);
        int par = partition(arr, low, high);

        quickSort(arr, low, par-1);
        quickSort(arr, par+1, high);

    }

    public static int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        //从后面开始找小于temp的值
        while(low < high) {
            while(low<high && arr[high]>=temp) {
                high--;
            }
            if(low == high) {
                break;
            }else {
                arr[low] = arr[high];
            }
            //从前面开始找大于temp的值
            while(low<high && arr[low]<=temp) {
                low++;
            }
            if(low == high) {
                break;
            }else {
                arr[high] = arr[low];
            }
        }
        //此时low等于high
        arr[low] = temp;
        return low;
    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    //保证arr[mid] <= arr[low] <= arr[high]
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
