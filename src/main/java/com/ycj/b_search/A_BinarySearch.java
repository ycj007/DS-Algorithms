package com.ycj.b_search;

import com.ycj.b_search.ab.BaseSearch;

public class A_BinarySearch extends BaseSearch {
    @Override
    protected int doSearch(int[] arr, int target) {

//        return binarySearch(arr, 0, arr.length - 1, target);
        return binarySearch2(arr, 0, arr.length - 1, target);
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return binarySearch(arr, left, mid - 1, target);
        }
        return binarySearch(arr, mid + 1, right, target);
    }

    private int binarySearch2(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
