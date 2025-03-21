package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

public class E_CountSortTest {

    private E_CountSort countSort;

    @Before
    public void setUp() {
        countSort = new E_CountSort();
    }

    @Test
    public void sort_EmptyArray_NoException() {
        int[] arr = {};
        countSort.sort(arr);
        assertArrayEquals("Empty array should remain unchanged", new int[]{}, arr);
    }

    @Test
    public void sort_SingleElementArray_NoException() {
        int[] arr = {5};
        countSort.sort(arr);
        assertArrayEquals("Single element array should remain unchanged", new int[]{5}, arr);
    }

    @Test
    public void sort_ArrayWithNegativeNumbers_ThrowsException() {
        int[] arr = {3, -1, 2};
        assertThrows(E_CountSort.UnsupportedNegativeNumberException.class, () -> countSort.sort(arr));
    }

    @Test
    public void sort_ArrayWithNonNegativeNumbers_SortsCorrectly() {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countSort.sort(arr);
        assertArrayEquals("Array should be sorted correctly", new int[]{1, 2, 2, 3, 3, 4, 8}, arr);
    }

    @Test
    public void sort_ArrayWithMaxValue_SortsCorrectly() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        countSort.sort(arr);
        assertArrayEquals("Array with max value should be sorted correctly", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }
}
