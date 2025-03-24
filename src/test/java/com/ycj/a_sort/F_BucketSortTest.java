package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class F_BucketSortTest {

    private F_BucketSort bucketSort;

    @Before
    public void setUp() {
        bucketSort = new F_BucketSort();
    }

    @Test
    public void sort_EmptyArray_ShouldReturnImmediately() {
        int[] arr = new int[]{};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_ShouldReturnImmediately() {
        int[] arr = new int[]{1};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void sort_SortedArray_ShouldRemainSorted() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void sort_UnsortedArray_ShouldSortCorrectly() {
        int[] arr = new int[]{5, 3, 8, 4, 2};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{2, 3, 4, 5, 8}, arr);
    }

    @Test
    public void sort_ArrayWithDuplicates_ShouldSortCorrectly() {
        int[] arr = new int[]{5, 3, 8, 4, 2, 3, 5};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{2, 3, 3, 4, 5, 5, 8}, arr);
    }

    @Test
    public void sort_ArrayWithNegativeNumbers_ShouldSortCorrectly() {
        int[] arr = new int[]{-5, -3, -8, -4, -2};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{-8, -5, -4, -3, -2}, arr);
    }

    @Test
    public void sort_ArrayWithMixedNumbers_ShouldSortCorrectly() {
        int[] arr = new int[]{-5, 3, 0, -2, 8};
        bucketSort.sort(arr);
        assertArrayEquals(new int[]{-5, -2, 0, 3, 8}, arr);
    }
}
