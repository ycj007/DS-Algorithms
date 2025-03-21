package com.ycj.a_sort.ds;

import java.util.PriorityQueue;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class CustomPriorityQueue {

    private int[] data;
    private int size = 0;

    public CustomPriorityQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new RuntimeException("maxSize must be greater than 0");
        }
        this.data = new int[maxSize];
    }

    public void insert(int value) {
        if (size >= data.length) {
            throw new RuntimeException("队列已满");
        }
        data[size] = value;
        swim(data, size);
        ++size;
    }

    public int delete() {
        if (size == 0) {
            throw new RuntimeException("队列已空");
        }
        int value = data[0];
        data[0] = data[size - 1];
        data[size - 1] = 0;
        --size;
        sink(data, 0);
        return value;
    }

    private void swim(int[] arr, int index) {
        int curIndex = index;
        while (curIndex > 0) {
            int parentIndex = getParent(curIndex);
            if (arr[parentIndex] >= arr[curIndex]) {
                break;
            }
            swap(arr, parentIndex, curIndex);
            curIndex = parentIndex;

        }

    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private void sink(int[] arr, int index) {

        int greaterIndex = index;
        while (greaterIndex < size) {
            int leftIndex = getLeftChild(index);
            if (arr[leftIndex] > arr[index]) {
                greaterIndex = leftIndex;
            }
            int rightIndex = getRightChild(index);
            if (arr[rightIndex] > arr[index]) {
                greaterIndex = rightIndex;
            }
            if (greaterIndex == index) {
                break;
            }
            swap(arr, greaterIndex, index);
            index = greaterIndex;

        }
    }


}
