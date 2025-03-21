package com.ycj.a_sort.ds;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CustomPriorityQueue<T extends Comparable<T>> {

    private Object[] data;
    private int size = 0;
    private boolean isMax = false;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE; // 定义最大容量
    private static final int MIN_CAPACITY = 8; // 定义最大容量

    public CustomPriorityQueue(int initCapacity) {
        if (initCapacity <= 0) {
            throw new RuntimeException("maxSize must be greater than 0");
        }
        this.data = new Object[initCapacity];
    }

    public CustomPriorityQueue(int maxSize, boolean isMax) {
        this(maxSize);
        this.isMax = isMax;
    }


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
        resize();
    }

    private void resize() {
        // 检查是否需要扩容
        if (size >= data.length) {
            // 确保 size 和 MAX_CAPACITY 的合法性
            if (data.length <= 0 || MAX_CAPACITY <= 0) {
                throw new IllegalStateException("Invalid array length or MAX_CAPACITY");
            }

            // 计算新的容量
            int expandedCapacity = data.length * 2;
            if (expandedCapacity > MAX_CAPACITY) {
                expandedCapacity = MAX_CAPACITY;
            }

            // 避免扩容后容量小于当前 size 的情况
            if (expandedCapacity < size) {
                throw new IllegalStateException("Expanded capacity is less than current size");
            }

            // 扩容操作
            try {
                data = Arrays.copyOf(data, expandedCapacity);
            } catch (OutOfMemoryError e) {
                throw new RuntimeException("Failed to resize array due to memory constraints", e);
            }
        }
    }

    /**
     * 当删除元素后，队列容量过大，则缩小容量，当前容量只有50% 使用时进行
     */
    private void reduceSize() {
        // 检查 data 是否为 null，避免 NullPointerException
        if (data == null) {
            return; // 如果 data 为 null，直接返回，无需缩小容量
        }
        if (size > data.length / 2) {
            return;
        }

        // 计算新的容量
        int newCapacity = calculateNewCapacity(data.length);

        // 如果新容量等于原容量，无需缩小
        if (newCapacity == data.length) {
            return;
        }

        // 缩小容量
        resizeArray(newCapacity);
    }

    /**
     * 计算新的容量，确保其大于等于最小容量（MIN_CAPACITY）
     */
    private int calculateNewCapacity(int currentCapacity) {
        int newCapacity = currentCapacity / 2;

        // 确保新容量不低于最小容量
        if (newCapacity < MIN_CAPACITY) {
            return MIN_CAPACITY;
        }

        return newCapacity;
    }

    /**
     * 调整数组大小
     */
    private void resizeArray(int newCapacity) {
        // 使用 Arrays.copyOf 进行调整
        data = Arrays.copyOf(data, newCapacity);

        // （可选）日志记录，便于调试和监控
        // System.out.println("Array capacity reduced to: " + newCapacity);
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
