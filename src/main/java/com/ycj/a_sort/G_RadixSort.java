package com.ycj.a_sort;

import com.ycj.a_sort.ab.BaseSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class G_RadixSort implements BaseSort {


    /**
     * 对整数数组进行排序，将负数和正数分别排序后合并
     * 此方法先将数组中的负数和正数分离，然后分别对它们进行排序，
     * 最后将两个有序数组合并成一个有序数组
     *
     * @param nums 待排序的整数数组，其中可能包含负数和正数
     */
    @Override
    public void sort(int[] nums) {
        // 如果数组为空或只有一个元素，则不需要排序，直接返回
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 分离并存储数组中的负数
        int[] nagtive = Arrays.stream(nums).filter(num -> num < 0).toArray();
        // 分离并存储数组中的正数
        int[] positive = Arrays.stream(nums).filter(num -> num > 0).toArray();

        // 对正数数组进行排序
        sortPositive(positive);
        // 对负数数组进行排序
        sortNagtive(nagtive);

        // 创建一个临时数组，用于合并排序后的负数和正数数组
        int[] buf = new int[nums.length];

        // 将排序后的负数数组复制到临时数组的前半部分
        System.arraycopy(nagtive, 0, buf, 0, nagtive.length);
        // 将排序后的正数数组复制到临时数组的后半部分
        System.arraycopy(positive, 0, buf, nums.length-positive.length, positive.length);

        // 将临时数组中的排序结果复制回原数组
        System.arraycopy(buf, 0, nums, 0, nums.length);
    }

    /**
     * 对负数数组进行排序
     * 本方法通过将数组中的负数转换为正数，利用已有的正数排序方法进行排序，然后将排序结果反转回负数形式
     * 这种方法可以避免直接处理负数，简化排序逻辑
     *
     * @param nums 待排序的负数数组
     */
    private void sortNagtive(int[] nums) {
        // 如果数组为空或只有一个元素，则不需要排序，直接返回
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 创建一个临时数组用于存储转换后的正数
        int[] temp = new int[nums.length];
        // 将原数组中的负数转换为正数存入临时数组
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i] * -1;
        }
        // 调用正数排序方法对临时数组进行排序
        sortPositive(temp);
        // 将排序后的正数数组转换回负数，并按照原排序顺序反转
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[nums.length-i-1] * -1;
        }
    }

    /**
     * 对正整数数组进行排序
     * 该方法使用基数排序算法，按位对数字进行排序
     *
     * @param nums 待排序的正整数数组
     */
    private void sortPositive(int[] nums) {
        // 如果数组为空或只有一个元素，则不需要排序，直接返回
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 初始化基数为1，用于逐位比较
        long exp = 1;
        // 数组长度
        int n = nums.length;
        // 临时数组，用于存放排序过程中的结果
        int[] buf = new int[n];
        // 找到数组中的最大值，以确定排序的轮数
        int maxVal = Arrays.stream(nums).max().getAsInt();

        // 当最大值大于当前基数时，继续排序
        while (maxVal >= exp) {
            // 计数数组，用于统计每位数字出现的次数
            int[] cnt = new int[10];
            // 统计当前位数上各数字出现的次数
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            // 累加计数，得到当前位数上各数字的累计出现次数
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            // 从右到左遍历原数组，根据当前位数上的数字进行排序
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            // 将排序结果复制回原数组
            System.arraycopy(buf, 0, nums, 0, n);
            // 增加基数，准备下一轮排序
            exp *= 10;
        }
    }
}
