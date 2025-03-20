package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class A_ShellSortTest {

    private A_ShellSort shellSort;

    @Before
    public void setUp() {
        shellSort = new A_ShellSort();
    }

    @Test
    public void sort_EmptyArray_ShouldRemainUnchanged() {
        int[] arr = {};
        shellSort.sort(arr);
        assertArrayEquals("Empty array should remain unchanged", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_ShouldRemainUnchanged() {
        int[] arr = {1};
        shellSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_ShouldRemainUnchanged() {
        int[] arr = {1, 2, 3, 4, 5};
        shellSort.sort(arr);
        assertArrayEquals("Already sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_ShouldBeSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        shellSort.sort(arr);
        assertArrayEquals("Reverse sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_RandomSortedArray_ShouldBeSorted() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        shellSort.sort(arr);
        assertArrayEquals("Random sorted array should be sorted", new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_ShouldBeSorted() {
        int[] arr = {3, 3, 2, 1, 1, 4, 5, 5, 6};
        shellSort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 1, 2, 3, 3, 4, 5, 5, 6}, arr);
    }

    @Test
    public void sort_LargeArray_ShouldBeSorted() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        shellSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertArrayEquals("Large array should be sorted", new int[]{i + 1}, new int[]{arr[i]});
        }
    }
}
