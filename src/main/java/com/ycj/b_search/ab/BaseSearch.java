package com.ycj.b_search.ab;

public abstract class BaseSearch {


    protected abstract int doSearch(int[] arr, int target);

    protected int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            if (arr[0] != target) {
                return 0;
            }
            return -1;
        }
        return doSearch(arr, target);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isAscSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
