package com.ycj.a_sort.ab;

import java.util.concurrent.ThreadLocalRandom;

public interface BaseSort {

    void sort(int[] arr);

    default void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    default void assertAesSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException("排序失败");
            }
        }
    }

    default void assertDesSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new RuntimeException("排序失败");
            }
        }
    }

    default int[][] getTestData() {
        int[][] arr = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                arr[i][j] = ThreadLocalRandom.current().nextInt(100);
            }
        }
        return arr;

    }

}
