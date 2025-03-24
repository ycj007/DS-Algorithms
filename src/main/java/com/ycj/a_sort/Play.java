package com.ycj.a_sort;

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
        int a = left+1;
        int b = right;
        while(a<=b){
            while(a<=b&&arr[a]<=pivot){
                a++;
            }
            while(a<=b&&arr[b]>pivot){
                b--;
            }
            if(a<b){
                swap(arr,a,b);
            }
        }
        swap(arr,left,b);
        return b;

    }

}
