package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

/**
 * 归并排序类，实现BaseSort接口
 * 归并排序是一种分治算法，它将数组分成两半，分别排序，然后合并
 */
public class C_MergeSort implements BaseSort {

    /**
     * 对外提供的排序接口方法
     *
     * @param arr 待排序的数组
     */
    @Override
    public void sort(int[] arr) {
        // 调用归并排序方法对整个数组进行排序
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序方法递归调用
     *
     * @param arr   待排序的数组
     * @param left  数组左边界
     * @param right 数组右边界
     */
    private void mergeSort(int[] arr, int left, int right) {
        // 当左边界大于等于右边界时，说明已经处理到最小单位，返回
        if (left >= right) {
            return;
        }
        // 计算中间点，用于分割数组
        int mid = (left + right) / 2;
        // 递归处理左半部分
        mergeSort(arr, left, mid);
        // 递归处理右半部分
        mergeSort(arr, mid + 1, right);
        // 合并左右两部分
        merge(arr, left, mid, right);
    }

    /**
     * 合并两个有序数组的方法
     *
     * @param arr   待排序的数组
     * @param left  左半部分的起始位置
     * @param mid   左半部分的结束位置，也是右半部分的起始位置
     * @param right 右半部分的结束位置
     */
    private void merge(int[] arr, int left, int mid, int right) {
        // 创建临时数组用于存放合并后的结果
        int[] temp = new int[right - left + 1];
        // 初始化左右半部分的指针和临时数组的指针
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 比较左右半部分的元素，将较小的放入临时数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 将剩余的左半部分元素放入临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 将剩余的右半部分元素放入临时数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 将临时数组的元素复制回原数组
        for (int l = 0; l < k; l++) {
            arr[left + l] = temp[l];
        }
    }

    /**
     * 就地合并排序好的两个相邻子数组（优化版）
     * 此方法直接在原数组上进行合并，不需要额外的辅助数组
     *
     * @param arr  待排序的数组
     * @param low  左半部分的起始位置
     * @param mid  左半部分的结束位置，也是右半部分的起始位置
     * @param high 右半部分的结束位置
     */
    public static void InPlaceMerge(int[] arr, int low, int mid, int high) {
        // 初始化左右半部分的指针
        int i = low;
        int j = mid + 1;
        // 遍历左右半部分，将较小的元素放入最终的位置
        while (i <= mid && j <= high) {
            // 如果 arr[i] 小于等于 arr[j]，则 i 指针后移
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                // 否则，将 arr[j] 插入到 arr[i] 的位置，其余元素后移
                int temp = arr[j];
                for (int k = j; k > i; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[i] = temp;
                i++;
                mid++;
                j++;
            }
        }
    }
}
