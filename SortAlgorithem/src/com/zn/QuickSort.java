package com.zn;

public class QuickSort {
    //快速排序
    public static void sort(int arr[],int low,int high){
        int i =low;
        int j = high;
        int key = arr[low];
        if(low < high){
            if (low < high) {
                // 枢纽元素
                System.out.println("枢纽元素是：" + key + ",low:" + low + ",high:" + high);

                while(i<j)
                {
                    while(i<j&&key<=arr[j])
                    {
                        j--;
                    }
                    arr[i]=arr[j];
//            int temp=a[j];这三行可以与前面一行互换，实现的功能相同。
//            a[j]=a[i];
//            a[i]=temp;</span>
                    while(i<j&&key>=arr[i])
                    {
                        i++;
                    }
                    arr[j]=arr[i];
//下面标红三行与上面一行功能相同
//            int temp1=a[j];
//            a[j]=a[i];
//            a[i]=temp1;</span>

                    arr[i]=key;
                }
                sort(arr,low,i-1);
          sort(arr,i+1,high);
            }
        }
    }


}
