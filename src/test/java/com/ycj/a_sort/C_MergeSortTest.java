package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class C_MergeSortTest {

    private C_MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new C_MergeSort();
    }

    @Test
    public void sort_EmptyArray_NoException() {
        int[] arr = {};
        mergeSort.sort(arr);
        assertArrayEquals("Empty array should remain empty", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_NoChange() {
        int[] arr = {1};
        mergeSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, arr);
    }

    @Test
    public void sort_TwoElementArray_Sorted() {
        int[] arr = {2, 1};
        mergeSort.sort(arr);
        assertArrayEquals("Two element array should be sorted", new int[]{1, 2}, arr);
    }

    @Test
    public void sort_EvenNumberOfElements_Sorted() {
        int[] arr = {4, 2, 5, 1, 3};
        mergeSort.sort(arr);
        assertArrayEquals("Even number of elements should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_OddNumberOfElements_Sorted() {
        int[] arr = {4, 2, 5, 1, 3, 6};
        mergeSort.sort(arr);
        assertArrayEquals("Odd number of elements should be sorted", new int[]{1, 2, 3, 4, 5, 6}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_Sorted() {
        int[] arr = {4, 2, 5, 1, 3, 2};
        mergeSort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 2, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseOrderArray_Sorted() {
        int[] arr = {6, 5, 4, 3, 2, 1};
        mergeSort.sort(arr);
        assertArrayEquals("Reverse order array should be sorted", new int[]{1, 2, 3, 4, 5, 6}, arr);
    }

    @Test
    public void sort_PartiallySortedArray_Sorted() {
        int[] arr = {1, 3, 2, 4, 5};
        mergeSort.sort(arr);
        assertArrayEquals("Partially sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }
}
