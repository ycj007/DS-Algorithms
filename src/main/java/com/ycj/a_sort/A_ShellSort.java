package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;


public class A_ShellSort implements BaseSort {

    @Override
    public void sort(int[] arr) {
        // 输入校验
        if (arr == null || arr.length <= 1) {
            return; // 如果数组为空或只有一个元素，直接返回
        }
        int h = getH( arr);

        for (int i = h; i > 0; i /= 2) {
            insertionSort(arr, i);
        }
    }

    private static void insertionSort(int[] arr, int h) {
        for (int k = h; k < arr.length; k+= h) {
            // 待插入的元素
            int element = arr[k];
            // 记录待插入位置
            int j = k - h;

            // 在已排序的序列中找到应该插入的位置
            while (j >= 0 && arr[j] > element) {
                arr[j + h] = arr[j]; // 将较大的元素后移
                j-= h; // 继续向前查找
            }

            // 插入元素到正确位置
            arr[j + h] = element;
        }
    }


    private int getH(int[] arr) {
        return arr.length / 2;
    }
}
