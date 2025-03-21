package com.ycj.a_sort.ds;

import java.util.PriorityQueue;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class CustomPriorityQueue {

    private int[] data;
    private int size = 0;
    private boolean isMax = false;

    public CustomPriorityQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new RuntimeException("maxSize must be greater than 0");
        }
        this.data = new int[maxSize];
    }

    public CustomPriorityQueue(int maxSize, boolean isMax) {
        this(maxSize);
        this.isMax = isMax;
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
        // 输入校验
        if (arr == null || index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Invalid input: array is null or index is out of bounds.");
        }

        int curIndex = index;
        while (curIndex > 0) {
            int parentIndex = getParent(curIndex);
            // 确保父节点索引有效
            if (parentIndex < 0) {
                break;
            }

            // 使用比较函数统一逻辑
            if (!shouldSwap(arr[parentIndex], arr[curIndex])) {
                break;
            }

            swap(arr, parentIndex, curIndex);
            curIndex = parentIndex;
        }
    }

    // 获取父节点索引
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    // 比较函数，根据isMax决定是否交换
    private boolean shouldSwap(int parentValue, int curValue) {
        if (isMax) {
            return parentValue < curValue; // 最大堆逻辑
        } else {
            return parentValue > curValue; // 最小堆逻辑
        }
    }

    // 交换数组中的两个元素
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private void sink(int[] arr, int index) {
        if (index >= size || index < 0) {
            return; // 确保索引有效
        }

        while (index < size) {
            int targetIndex = index;
            int leftIndex = getLeftChild(index);
            int rightIndex = getRightChild(index);

            // 找到左右子节点中符合条件的最大/最小索引
            if (leftIndex < size && compare(arr[leftIndex], arr[targetIndex])) {
                targetIndex = leftIndex;
            }
            if (rightIndex < size && compare(arr[rightIndex], arr[targetIndex])) {
                targetIndex = rightIndex;
            }

            // 如果当前节点已经是最大/最小节点，则停止下沉
            if (targetIndex == index) {
                break;
            }

            // 交换并继续下沉
            swap(arr, index, targetIndex);
            index = targetIndex;
        }
    }

    // 辅助方法：根据 isMax 决定比较逻辑
    private boolean compare(int a, int b) {
        return isMax ? a > b : a < b;
    }


}
