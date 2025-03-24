package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class F_BucketSort implements BaseSort {

/**
 * 重写排序方法，使用桶排序算法对整数数组进行排序
 * 桶排序通过将数组分到多个桶中，然后每个桶分别排序，最后合并到一起
 * 这个实现主要处理了桶的大小和数量的计算，以及如何将元素分配到桶中并重新写回到原数组
 *
 * @param arr 待排序的整数数组，不应为null或空
 */
@Override
public void sort(int[] arr) {
    // 如果数组为空或只有一个元素，则不需要排序，直接返回
    if (arr == null || arr.length <= 1) {
        return;
    }

    try {
        // 找出数组中的最小值和最大值，以确定桶的大小
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        // 根据数组长度和值范围计算桶的大小，确保每个桶能覆盖一定的值范围
        int bucketSize = Math.max(1, (max - min) / arr.length + 1);
        int bucketCount = (int) Math.floor((max - min) / bucketSize) + 1;

        // 使用ArrayList来动态管理桶中的元素
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 将元素分配到桶中
        for (int num : arr) {
            int bucketIndex = (num - min) / bucketSize;
            buckets[bucketIndex].add(num);
        }

        // 对每个桶进行排序并合并回原数组
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                // 使用内置排序算法对桶内元素排序
                bucket.sort(null);

                // 将桶中的元素写回到原数组
                for (int num : bucket) {
                    arr[index++] = num;
                }
            }
        }
    } catch (NoSuchElementException e) {
        throw new IllegalArgumentException("Input array must not be empty", e);
    }
}

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
