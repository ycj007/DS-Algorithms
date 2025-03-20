package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class A_SelectionSortTest {

    private A_SelectionSort selectionSort;

    @Before
    public void setUp() {
        selectionSort = new A_SelectionSort();
    }

    @Test
    public void sort_EmptyArray_NoChange() {
        int[] arr = {};
        selectionSort.sort(arr);
        assertArrayEquals("Empty array should remain unchanged", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_NoChange() {
        int[] arr = {1};
        selectionSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_NoChange() {
        int[] arr = {1, 2, 3, 4, 5};
        selectionSort.sort(arr);
        assertArrayEquals("Already sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_Sorted() {
        int[] arr = {5, 4, 3, 2, 1};
        selectionSort.sort(arr);
        assertArrayEquals("Reverse sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_RandomOrderArray_Sorted() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        selectionSort.sort(arr);
        assertArrayEquals("Random order array should be sorted", new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_Sorted() {
        int[] arr = {3, 1, 2, 1, 3, 2, 1};
        selectionSort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 1, 1, 2, 2, 3, 3}, arr);
    }
}
