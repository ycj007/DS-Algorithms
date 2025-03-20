package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class A_InsertionSortTest {

    private A_InsertionSort insertionSort;

    @Before
    public void setUp() {
        insertionSort = new A_InsertionSort();
    }

    @Test
    public void sort_EmptyArray_NoChange() {
        int[] arr = {};
        insertionSort.sort(arr);
        assertArrayEquals("Empty array should remain unchanged", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_NoChange() {
        int[] arr = {5};
        insertionSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{5}, arr);
    }

    @Test
    public void sort_UnsortedArray_SortedArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        insertionSort.sort(arr);
        assertArrayEquals("Unsorted array should be sorted", new int[]{1, 2, 5, 5, 6, 9}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_NoChange() {
        int[] arr = {1, 2, 3, 4, 5};
        insertionSort.sort(arr);
        assertArrayEquals("Already sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_SortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        insertionSort.sort(arr);
        assertArrayEquals("Reverse sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_SortedArray() {
        int[] arr = {5, 3, 8, 3, 9, 1};
        insertionSort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 3, 3, 5, 8, 9}, arr);
    }
}
