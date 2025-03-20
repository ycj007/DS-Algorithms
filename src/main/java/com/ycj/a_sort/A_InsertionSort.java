package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

/**
 * 将数组分为两部分，已排序部分和未排序部分，将未排序部分中的元素插入已排序部分中，使得整个数组有序。
 */
public class A_InsertionSort implements BaseSort {
    /**
     * 对整数数组进行排序
     * 使用插入排序算法，将数组中的元素逐步插入到已排序序列中的正确位置
     *
     * @param arr 待排序的整数数组
     */
    @Override
    public void sort(int[] arr) {
        // 输入校验
        if (arr == null || arr.length < 2) {
            return; // 如果数组为空或只有一个元素，无需排序
        }

        for (int i = 1; i < arr.length; i++) {
            // 待插入的元素
            int element = arr[i];
            // 记录待插入位置
            int j = i - 1;

            // 在已排序的序列中找到应该插入的位置
            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j]; // 将较大的元素后移
                j--; // 继续向前查找
            }

            // 插入元素到正确位置
            arr[j + 1] = element;
        }
    }
}
