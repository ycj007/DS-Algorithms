package com.ycj.b_search;

import com.ycj.b_search.ab.BaseSearch;

public class B_InsertSearch extends BaseSearch {
    @Override
    protected int doSearch(int[] arr, int target) {

        return insertSearch(arr, 0, arr.length - 1, target);
    }

    private int insertSearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return arr[left] == target ? left : -1;
        }
        int mid = left + (right - left) / (arr[right] - arr[left]) * (target - arr[left]);
        if (mid < left || mid > right) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return insertSearch(arr, left, mid - 1, target);
        }
        return insertSearch(arr, mid + 1, right, target);
    }


}
