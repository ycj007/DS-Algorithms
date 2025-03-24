package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

public class B_QuickSort implements BaseSort {
    @Override
    /**
     * 对整数数组进行快速排序
     * 快速排序是一种高效的排序算法，使用分治法策略它的工作原理是选取一个元素作为"基准"（pivot），
     * 然后将数组分为两部分：一部分包含小于基准的元素，另一部分包含大于基准的元素，这个过程称为"分区"（partitioning），
     * 接着递归地在这两部分上重复进行快速排序，直到整个序列有序
     *
     * @param arr 待排序的整数数组
     */
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序的主要实现方法
     * 通过递归调用自身来对数组的子序列进行排序
     *
     * @param arr   待排序的整数数组
     * @param left  子序列的起始索引
     * @param right 子序列的结束索引
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition2(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    /**
     * 执行分区操作，将数组分为两部分
     * 选取第一个元素作为基准，然后将所有小于基准的元素移动到基准左侧，所有大于基准的元素移动到基准右侧
     *
     * @param arr   待排序的整数数组
     * @param left  子序列的起始索引
     * @param right 子序列的结束索引
     * @return 基准元素的最终索引
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    //2.双向扫描分区法（两指正等地位，向中间扫描）
    public int partition3(int[] arr, int begin, int end) {
        int pivot = arr[begin];//确定主元为数组的第一个元素
        int left = begin + 1;//左侧指针
        int right = end;//右侧指针
        while (left <= right) {
            //注意加left<=right条件，防止左右指针咋在外部while的内部相交
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            //注意：交换左右指针所指元素时也要判定left<=right
            //因为在上面两个while中可能导致left和right错位
            if (left <= right) swap(arr, left, right);
        }
        //退出while表示已经相交，找到了pivot的最终位置:right位置(由arr[left]<=pivot决定)
        swap(arr, begin, right);
        return right;//返回位置
    }

    private int partition2(int[] arr, int left, int right) {
        int pivot = arr[left];
        int index = left;
        while (index < right) {
            if (arr[index] > pivot) {
                swap(arr, index, right--);
                continue;
            }
            index++;
        }
        if (index != left) {
            if (arr[index] <= pivot) {
                swap(arr, left, index);
            } else {
                swap(arr, left, --index);
            }
        }

        return index;


    }
}
