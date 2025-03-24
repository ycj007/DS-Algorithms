package com.ycj.a_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Play {


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubblesort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //1.内部循环一次，两两对比 ，最大元素到最后
        //2。外部循环次数，每次循环，最大元素到最右边
        for (int limit = arr.length - 1; limit > 0; limit--) {
            for (int i = 0; i < limit; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 将数组分为两部分 有序部分和无序部分，每次从无序部分调出一个元素，插入到有序部分
        //无序部分
        for (int i = 1; i < arr.length; i++) {
            int insertObj = arr[i];
            int targetIndext = i - 1;
            for (int j = i - 1; j > -1; j--) {
                if (arr[j] <= insertObj) {
                    targetIndext = j;
                    break;
                }
                arr[j + 1] = arr[j];
                targetIndext = j - 1;
            }
            arr[targetIndext + 1] = insertObj;
        }

    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }


        for (int j = 0; j < arr.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            swap(arr, j, min);
        }

    }

    public static void shellSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;
        int h = n / 2;
        while (h >= 1) {

            for (int i = h; i < n; i += h) {
                int element = arr[i];//待插入元素
                int j = i - h;//待插入位置
                while (j >= 0 && arr[j] > element) {
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = element;
            }
            h = h / 2;

        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 快速排序是分治法的体现
         * 首先选出一个标的，将所有小于等于标的的元素放在左边，大于标的的元素放在右边
         * 然后再递归得处理左边和右边，直到处理完所有元素
         * 当只有一个元素或者0个元素时，递归结束，返回
         */

        doQuickSort(arr, 0, arr.length - 1);

    }

    private static void doQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        doQuickSort(arr, left, partitionIndex - 1);
        doQuickSort(arr, partitionIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int a = left + 1;
        int b = right;
        while (a <= b) {
            while (a <= b && arr[a] <= pivot) {
                a++;
            }
            while (a <= b && arr[b] > pivot) {
                b--;
            }
            if (a < b) {
                swap(arr, a, b);
            }
        }
        swap(arr, left, b);
        return b;

    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 归并排序是分治法的体现
         * 首先将数组分为左右两个部分，然后分别对左右两个部分进行排序，然后将两个部分合并成一个有序的数组
         */
        mergeSort(arr, 0, arr.length - 1);

    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[tempIndex] = arr[i];
                i++;
            } else {
                temp[tempIndex] = arr[j];
                j++;
            }
            tempIndex++;
        }
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            i++;
            tempIndex++;
        }
        while (j <= right) {
            temp[tempIndex] = arr[j];
            j++;
            tempIndex++;
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //构建大顶堆
        int n = arr.length;
        for (int i = n / 2; i > -1; i--) {
            sink(arr, i, n);
        }
        for (int i = n - 1; i > -1; i--) {
            swap(arr, 0, i);
            sink(arr, 0, i);
        }

    }

    private static void sink(int[] arr, int index, int n) {
        if (index >= n) {
            return;
        }
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int max = index;
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }
        if (max != index) {
            swap(arr, index, max);
            sink(arr, max, n);
        }
    }

    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] positive = Arrays.stream(arr).filter(i -> i >= 0).toArray();
        sortPositive(positive);
        int[] nagative = Arrays.stream(arr).filter(i -> i < 0).toArray();
        for (int i = 0; i < nagative.length; i++) {
            nagative[i] = -nagative[i];
        }
        sortPositive(nagative);
        int index = 0;
        for (int i = nagative.length - 1; i > -1; i--) {
            arr[index++] = -nagative[i];
        }
        for (int i = 0; i < positive.length; i++) {
            arr[index++] = positive[i];
        }

    }

    private static void sortPositive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] temp = arr.clone();
        for (int i = 0; i < temp.length; i++) {
//            int num = temp[i];
//            arr[count[num] - 1] = num;
//            count[num]--;
            arr[--count[temp[i]]] = temp[i];
        }
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int bucketNum = (int) Math.sqrt(arr.length);
        List<List<Integer>> bucketList = new ArrayList<>();

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int bucketSize = (max - min) / bucketNum + 1;
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int bucketIndex = (element - min) / bucketSize;
            bucketList.get(bucketIndex).add(element);
        }
        int index = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            List<Integer> bucket = bucketList.get(i);
            Collections.sort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                arr[index++] = bucket.get(j);
            }
        }
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int min = Arrays.stream(arr).min().getAsInt();
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= min;
            }
        }
        String max = Arrays.stream(arr).max().getAsInt() + "";
        int index = 0;
        int[] bucket = new int[arr.length];
        int exp = 1;
        while (index < max.length()) {
            int[] count = new int[10];
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                int digit = (num / exp) % 10;
                count[digit]++;

            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i > -1; i--) {
                int num = arr[i];
                int digit = (num / exp) % 10;
                bucket[count[digit] - 1] = num;
                count[digit]--;
            }

            System.arraycopy(bucket, 0, arr, 0, arr.length);
            exp = exp * 10;
            index++;
        }
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += min;
            }
        }
    }


}
