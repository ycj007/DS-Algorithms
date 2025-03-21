package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

/**
 * 归并排序类，实现BaseSort接口
 * 归并排序是一种分治算法，它将数组分成两半，分别排序，然后合并
 */
public class D_DumpSort implements BaseSort {

    /**
     * 对外提供的排序接口方法
     *
     * @param arr 待排序的数组
     */
    @Override
    public void sort(int[] arr) {

        // 从数组的中间位置开始，向前遍历，逐个节点进行堆化调整
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for(int i=arr.length-1;i>-1;i--){
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }




    private void heapify(int[] arr, int k, int n) {
        int largest = k;
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != k) {
            swap(arr, k, largest);
            heapify(arr, largest, n);
        }
    }


}
