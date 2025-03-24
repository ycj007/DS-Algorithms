package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class G_RadixSortTest {

    private G_RadixSort radixSort;

    @Before
    public void setUp() {
        radixSort = new G_RadixSort();
    }

    @Test
    public void sort_NullArray_NoException() {
        int[] nums = null;
        radixSort.sort(nums);
        // 如果没有抛出异常，则测试通过
    }

    @Test
    public void sort_SingleElementArray_NoChange() {
        int[] nums = {5};
        radixSort.sort(nums);
        assertArrayEquals(new int[]{5}, nums);
    }

    @Test
    public void sort_MultipleElementsArray_Sorted() {
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        radixSort.sort(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sort_AllZeroesArray_NoChange() {
        int[] nums = {0, 0, 0, 0};
        radixSort.sort(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0}, nums);
    }

    @Test
    public void sort_NegativeNumbersArray_Sorted() {
        int[] nums = {-170, -45, -75, -90, -802, -24, -2, -66};
        int[] expected = {-802, -170, -90, -75, -66, -45, -24, -2};
        radixSort.sort(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void sort_MaxIntegerArray_NoChange() {
        int[] nums = {Integer.MAX_VALUE};
        radixSort.sort(nums);
        assertArrayEquals(new int[]{Integer.MAX_VALUE}, nums);
    }
}
