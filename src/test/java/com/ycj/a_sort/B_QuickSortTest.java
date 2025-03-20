package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class B_QuickSortTest {

    private B_QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new B_QuickSort();
    }

    @Test
    public void sort_EmptyArray_ShouldRemainEmpty() {
        int[] arr = {};
        quickSort.sort(arr);
        assertArrayEquals("Empty array should remain empty", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_ShouldRemainUnchanged() {
        int[] arr = {1};
        quickSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_ShouldRemainUnchanged() {
        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        assertArrayEquals("Already sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_ShouldBeSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort.sort(arr);
        assertArrayEquals("Reverse sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_ShouldBeSorted() {
        int[] arr = {3, 1, 2, 3, 1};
        quickSort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    public void sort_RandomArray_ShouldBeSorted() {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        quickSort.sort(arr);
        assertArrayEquals("Random array should be sorted", new int[]{1, 1, 2, 3, 6, 8, 10}, arr);
    }
}
