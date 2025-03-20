package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;


public class A_BubbleSort implements BaseSort {

    @Override
    public void sort(int[] arr) {
        // 输入校验
        if (arr == null || arr.length <= 1) {
            return; // 如果数组为空或只有一个元素，直接返回
        }

        // 冒泡排序逻辑
        boolean swapped; // 标志位，用于检测是否发生交换
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            swapped = false; // 每轮初始化为 false

            // 内层循环控制比较次数
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1); // 调用 swap 方法进行交换
                    swapped = true;     // 发生了交换，设置标志位为 true
                }
            }

            // 如果某一轮没有发生交换，说明数组已经有序，提前结束
            if (!swapped) {
                break;
            }
        }
    }
}
