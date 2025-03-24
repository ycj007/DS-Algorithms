package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlayTest {

    private int[] emptyArray;
    private int[] singleElementArray;
    private int[] sortedArray;
    private int[] unsortedArray;
    private int[] arrayWithDuplicates;
    private int[] arrayWithNegativesAndZero;

    @Before
    public void setUp() {
        emptyArray = new int[]{};
        singleElementArray = new int[]{1};
        sortedArray = new int[]{1, 2, 3, 4, 5};
        unsortedArray = new int[]{5, 3, 1, 4, 2};
        arrayWithDuplicates = new int[]{3, 1, 2, 3, 1};
        arrayWithNegativesAndZero = new int[]{0, -1, 2, -3, 1};
    }

    @Test
    public void quickSort_EmptyArray_ShouldRemainUnchanged() {
        Play.quickSort(emptyArray);
        assertArrayEquals("Empty array should remain unchanged", new int[]{}, emptyArray);
    }

    @Test
    public void quickSort_SingleElementArray_ShouldRemainUnchanged() {
        Play.quickSort(singleElementArray);
        assertArrayEquals("Single element array should remain unchanged", new int[]{1}, singleElementArray);
    }

    @Test
    public void quickSort_SortedArray_ShouldRemainUnchanged() {
        Play.quickSort(sortedArray);
        assertArrayEquals("Sorted array should remain unchanged", new int[]{1, 2, 3, 4, 5}, sortedArray);
    }

    @Test
    public void quickSort_UnsortedArray_ShouldBeSorted() {
        Play.quickSort(unsortedArray);
        assertArrayEquals("Unsorted array should be sorted", new int[]{1, 2, 3, 4, 5}, unsortedArray);
    }

    @Test
    public void quickSort_ArrayWithDuplicates_ShouldBeSorted() {
        Play.quickSort(arrayWithDuplicates);
        assertArrayEquals("Array with duplicates should be sorted", new int[]{1, 1, 2, 3, 3}, arrayWithDuplicates);
    }

    @Test
    public void quickSort_ArrayWithNegativesAndZero_ShouldBeSorted() {
        Play.quickSort(arrayWithNegativesAndZero);
        assertArrayEquals("Array with negatives and zero should be sorted", new int[]{-3, -1, 0, 1, 2}, arrayWithNegativesAndZero);
    }
}
