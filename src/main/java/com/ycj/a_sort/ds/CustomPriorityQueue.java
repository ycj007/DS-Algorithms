package com.ycj.a_sort.ds;

import java.util.NoSuchElementException;

public class CustomPriorityQueue<T extends Comparable<T>> {

    private Object[] data;
    private int size = 0;
    private boolean isMax = false;

    public CustomPriorityQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new RuntimeException("maxSize must be greater than 0");
        }
        this.data = new Object[maxSize];
    }

    public CustomPriorityQueue(int maxSize, boolean isMax) {
        this(maxSize);
        this.isMax = isMax;
    }


    private static final int MAX_CAPACITY = Integer.MAX_VALUE; // 定义最大容量

    /**
     * 插入元素
     *
     * @param value 不允许 null
     * @throws IllegalArgumentException 如果 value 为 null
     * @throws IllegalStateException    如果队列已满
     */
    public void insert(T value) {
        // 参数校验：确保 value 不为 null
        if (value == null) {
            throw new IllegalArgumentException("插入的值不允许为 null");
        }

        // 边界条件检查：确保队列未满
        if (size >= data.length) {
            throw new IllegalStateException("队列已满，当前容量：" + data.length + "，最大容量：" + MAX_CAPACITY);
        }

        // 插入元素并调整堆结构
        data[size] = value;
        swim(data, size); // 调整堆结构
        ++size;
    }


    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("队列已空，无法执行 peek 操作。当前队列大小为: " + size);
        }
        return (T) data[0]; // 假设 data 数组中的元素类型与泛型 T 一致
    }


    public T delete() {
        if (size == 0) {
            throw new NoSuchElementException("队列已空");
        }

        // 特殊情况：如果队列中只有一个元素，直接返回并调整 size
        if (size == 1) {
            T value = (T) data[0];
            data[0] = null; // 清空引用，便于垃圾回收
            size = 0;
            return value;
        }

        T value = (T) data[0]; // 获取堆顶元素
        data[0] = data[size - 1]; // 将最后一个元素移动到堆顶
        data[size - 1] = null; // 清空最后一个位置的引用
        size--; // 更新堆大小
        sink(data, 0); // 下沉操作以恢复堆的性质
        return value;
    }


    private void swim(Object[] arr, int index) {
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
            if (!shouldSwap((T) arr[parentIndex], (T) arr[curIndex])) {
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
    private boolean shouldSwap(T parentValue, T curValue) {
        // 检查参数是否为null
        if (parentValue == null || curValue == null) {
            throw new IllegalArgumentException("Comparison values cannot be null");
        }

        // 使用比较器进行比较
        int comparisonResult = parentValue.compareTo(curValue);

        // 根据isMax决定比较逻辑
        return isMax ? comparisonResult < 0 : comparisonResult > 0;
    }

    // 交换数组中的两个元素
    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private void sink(Object[] arr, int index) {
        if (index >= size || index < 0) {
            return; // 确保索引有效
        }

        while (index < size) {
            int targetIndex = index;
            int leftIndex = getLeftChild(index);
            int rightIndex = getRightChild(index);

            // 找到左右子节点中符合条件的最大/最小索引
            if (leftIndex < size && compare((T) arr[leftIndex], (T) arr[targetIndex])) {
                targetIndex = leftIndex;
            }
            if (rightIndex < size && compare((T) arr[rightIndex], (T) arr[targetIndex])) {
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
    private boolean compare(T a, T b) {
        // 检查 null 值
        if (a == null && b == null) {
            return false; // 根据业务需求调整
        }
        if (a == null) {
            return isMax; // 如果 a 为 null，返回 isMax 的值
        }
        if (b == null) {
            return !isMax; // 如果 b 为 null，返回 !isMax 的值
        }

        // 使用 compareTo 方法进行比较
        int comparison = a.compareTo(b);
        return isMax ? comparison > 0 : comparison < 0;
    }


}
