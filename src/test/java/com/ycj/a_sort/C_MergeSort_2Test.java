package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class C_MergeSort_2Test {

    private C_MergeSort_2 mergeSort;

    @Before
    public void setUp() {
        mergeSort = new C_MergeSort_2();
    }

    @Test
    public void sort_EmptyArray_ShouldRemainEmpty() {
        int[] arr = {};
        mergeSort.sort(arr);
        assertArrayEquals("Empty array should remain empty", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_ShouldRemainUnchanged() {
        int[] arr = {1};
        mergeSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, arr);
    }

    @Test
    public void sort_TwoElementArray_ShouldBeSorted() {
        int[] arr = {2, 1};
        mergeSort.sort(arr);
        assertArrayEquals("Two element array should be sorted", new int[]{1, 2}, arr);
    }

    @Test
    public void sort_EvenNumberOfElements_ShouldBeSorted() {
        int[] arr = {4, 2, 5, 1};
        mergeSort.sort(arr);
        assertArrayEquals("Even number of elements should be sorted", new int[]{1, 2, 4, 5}, arr);
    }

    @Test
    public void sort_OddNumberOfElements_ShouldBeSorted() {
        int[] arr = {4, 2, 5, 1, 3};
        mergeSort.sort(arr);
        assertArrayEquals("Odd number of elements should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_ShouldRemainUnchanged() {
        int[] arr = {1, 2, 3, 4, 5};
        mergeSort.sort(arr);
        assertArrayEquals("Already sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_ShouldBeSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort.sort(arr);
        assertArrayEquals("Reverse sorted array should be sorted", new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_ShouldBeSorted() {
        int[] arr = {4, 2, 5, 1, 3, 2};
        mergeSort.sort(arr);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 2, 2, 3, 4, 5}, arr);
    }
}
