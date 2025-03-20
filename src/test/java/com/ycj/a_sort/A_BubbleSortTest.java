package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class A_BubbleSortTest {

    private A_BubbleSort bubbleSort;

    @Before
    public void setUp() {
        bubbleSort = new A_BubbleSort();
    }

    @Test
    public void sort_NullArray_ShouldReturnImmediately() {
        int[] arr = null;
        bubbleSort.sort(arr);
        assertArrayEquals(null, arr);
    }

    @Test
    public void sort_SingleElementArray_ShouldRemainUnchanged() {
        int[] arr = {1};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void sort_UnsortedArray_ShouldSortCorrectly() {
        int[] arr = {5, 3, 8, 4, 2};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{2, 3, 4, 5, 8}, arr);
    }

    @Test
    public void sort_AlreadySortedArray_ShouldRemainUnchanged() {
        int[] arr = {1, 2, 3, 4, 5};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ReverseSortedArray_ShouldSortCorrectly() {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_ShouldSortCorrectly() {
        int[] arr = {3, 1, 2, 3, 1};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }
}
