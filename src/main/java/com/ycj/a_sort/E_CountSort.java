package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

public class E_CountSort implements BaseSort {


    /**
     * 重写排序方法，专门处理非负整数的排序
     * 此方法首先检查数组中是否包含负数，如果包含则抛出异常
     * 否则，找到数组中的最大值，并根据最大值的大小决定是否进行计数排序
     *
     * @param arr 待排序的整数数组
     * @throws UnsupportedNegativeNumberException 如果数组中包含负数，则抛出此异常
     */
    @Override
    public void sort(int[] arr) {
        // 判断数组是否为空或只有一个元素，如果是，不需要排序，直接返回
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 初始化变量，max用于记录数组中的最大值，hasNegative用于标记数组中是否有负数
        int max = Integer.MIN_VALUE;
        boolean hasNegative = false;

        // 单次遍历检测负数并找到最大值
        for (int num : arr) {
            // 如果发现负数，设置标志为true，并中断遍历，因为不需要继续
            if (num < 0) {
                hasNegative = true;
                break;
            }
            // 如果当前数字大于已知的最大值，更新最大值
            if (num > max) {
                max = num;
            }
        }

        // 如果存在负数，抛出自定义异常，表示不支持排序包含负数的数组
        if (hasNegative) {
            throw new UnsupportedNegativeNumberException("负数不支持");
        }

        // 执行计数排序，这是基于最大值的排序算法，适合一定条件下的整数排序
        countingSort(arr, max);
    }

    /**
     * 使用计数排序算法对数组进行排序。
     * 计数排序是一种非比较排序算法，适用于一定范围内的整数排序。
     * 它通过计算每个整数的出现次数来实现排序。
     * 此方法直接在输入数组内进行排序，因此不需要额外的结果数组。
     *
     * @param arr 待排序的整数数组（必须为非空且只包含非负整数）
     * @param max 数组中最大可能的整数值（必须大于等于数组中的最大值）
     * @throws IllegalArgumentException 如果输入数组为空或包含负数，或 max 参数不合理
     */
    private void countingSort(int[] arr, int max) {
        // 检查输入数组是否为空
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("输入数组不能为空");
        }

        // 验证数组中是否存在负数或 max 参数是否合理
        for (int num : arr) {
            if (num < 0) {
                throw new IllegalArgumentException("数组中包含负数，计数排序不支持负数");
            }
            if (num > max) {
                throw new IllegalArgumentException("数组中存在大于 max 的值，max 参数不合理");
            }
        }

        // 创建计数数组
        int[] countArray = new int[max + 1];

        // 统计每个整数出现的次数
        for (int num : arr) {
            countArray[num]++;
        }

        // 计算累积计数
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        //直接在原数组上进行排序
        int[] temp = arr.clone(); // 使用临时数组保存原始数据
        for (int i = temp.length - 1; i >= 0; i--) {
            int num = temp[i];
            arr[countArray[num] - 1] = num;
            countArray[num]--;
        }

    }

    /**
     * 使用计数排序算法对数组进行排序
     * 计数排序是一种非比较排序算法，适用于一定范围内的整数排序它通过计算每个整数的出现次数来实现排序
     * 此方法直接在输入数组上进行排序，不需要额外的排序空间
     *
     * @param arr 待排序的整数数组
     * @param max 数组中可能出现的最大整数
     * @throws IllegalArgumentException 如果输入数组为空，或包含负数，或max参数不合理（小于数组中的最大值）
     */
    private void countingSort2(int[] arr, int max) {
        // 检查输入数组是否为空
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("输入数组不能为空");
        }

        // 验证数组中是否存在负数或 max 参数是否合理
        for (int num : arr) {
            if (num < 0) {
                throw new IllegalArgumentException("数组中包含负数，计数排序不支持负数");
            }
            if (num > max) {
                throw new IllegalArgumentException("数组中存在大于 max 的值，max 参数不合理");
            }
        }

        // 创建计数数组
        int[] countArray = new int[max + 1];

        // 统计每个整数出现的次数
        for (int num : arr) {
            countArray[num]++;
        }

        // 将计数数组中的计数转换为索引位置，对原数组进行排序
        int sortedIndex = 0;
        for (int j = 0; j < countArray.length; j++) {
            while (countArray[j] > 0) {
                arr[sortedIndex++] = j;
                countArray[j]--;
            }
        }
    }


    // 自定义异常类
    public static class UnsupportedNegativeNumberException extends RuntimeException {
        public UnsupportedNegativeNumberException(String message) {
            super(message);
        }
    }
}

