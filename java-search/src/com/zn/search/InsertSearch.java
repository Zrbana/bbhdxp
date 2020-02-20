package com.zn.search;

public class InsertSearch {

    public static int insertSearch(int[] array, int key) {
        return search2(array, key, 0, array.length - 1);
    }

    /**
     * 非递归版本的插入查找
     * @param array
     * @param key
     * @param left
     * @param right
     * @return
     */
    private static int search(int[] array, int key, int left, int right) {
        while (left <= right) {
            if (array[right] == array[left]) {
                if (array[right] == key)
                    return right;
                else return -1;
            }
            int middle = left + ((key - array[left]) / (array[right] - array[left])) * (right - left);
            if (array[middle] == key) {
                return middle;
            }
            if (key < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }



    /**
     * 递归版本的插入查找
     * @param array
     * @param key
     * @param left
     * @param right
     * @return
     */
    private static int search2(int array[], int key, int left, int right) {
        if (left > right)
            return -1;
        if (array[right] == array[left]) {
            if (array[right] == key)
                return right;
            else return -1;
        }
        int mid = left + (key - array[left]) / (array[right] - array[left]) * (right - left);
        if (array[mid] == key)
            return mid;
        if (array[mid] > key)
            return search2(array, key, left, mid - 1);
        return search2(array, key, mid + 1, right);
    }
}
