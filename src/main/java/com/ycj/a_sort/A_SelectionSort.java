package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

/**
 * 找到数组中最小的数据，将它和数组第一个数据交换;
 * 再剩下的数据中找到最小的数据与第二个数据交换;
 * 以此往复;
 */
public class A_SelectionSort implements BaseSort {
    @Override
    public void sort(int[] arr) {
        // 检查数组是否为空或长度是否小于2，因为选择排序需要至少两个元素来进行比较和交换
        if (arr == null || arr.length < 2) {
            return;
        }

        // 遍历数组，进行选择排序
        for (int index = 0; index < arr.length; index++) {
            // 初始化当前认为最小的元素索引和值
            int minDataIndex = index;

            // 在未排序的部分中寻找最小元素的索引
            for (int i = index; i < arr.length; i++) {
                // 如果找到更小的元素，更新最小元素的索引和值
                if (arr[i] < arr[minDataIndex]) {
                    minDataIndex = i;
                }
            }

            // 如果当前索引不是最小元素的索引，则交换它们
            if (index != minDataIndex) {
                swap(arr, index, minDataIndex);
            }
        }
    }
}
