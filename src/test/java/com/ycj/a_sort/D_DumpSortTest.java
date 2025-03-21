package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class D_DumpSortTest {

    private D_DumpSort sort;

    @Before
    public void setUp() {
        sort = new D_DumpSort();
    }

    @Test
    public void sort_EmptyArray_ShouldRemainEmpty() {
        int[] arr = {};
        sort.sort(arr);
        assertArrayEquals("Empty array should remain empty", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_ShouldRemainUnchanged() {
        int[] arr = {1};
        sort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_ShouldRemainUnchanged() {
        int[] arr = {1, 2, 3, 4, 5};
        sort.sort(arr);
        assertArrayEquals("Already sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_ShouldBeSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        sort.sort(arr);
        assertArrayEquals("Reverse sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_RandomOrderArray_ShouldBeSorted() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        sort.sort(arr);
        assertArrayEquals("Random order array should be sorted", new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_ShouldBeSorted() {
        int[] arr = {3, 3, 3, 2, 2, 1, 1};
        sort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 1, 2, 2, 3, 3, 3}, arr);
    }

    @Test
    public void sort_ArrayWithNegativeNumbersAndZero_ShouldBeSorted() {
        int[] arr = {-1, 0, 1, -2, 2, -3, 3};
        sort.sort(arr);
        assertArrayEquals("Array with negative numbers and zero should be sorted", new int[]{-3, -2, -1, 0, 1, 2, 3}, arr);
    }
}
