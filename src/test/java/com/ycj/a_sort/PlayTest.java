package com.ycj.a_sort;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlayTest {

    private int[] arr;

    @Before
    public void setUp() {
        arr = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
    }

    @Test
    public void radixSort_NullArray_NoChange() {
        int[] nullArray = null;
        Play.radixSort(nullArray);
        assertArrayEquals(null, nullArray);
    }

    @Test
    public void radixSort_EmptyArray_NoChange() {
        int[] emptyArray = {};
        Play.radixSort(emptyArray);
        assertArrayEquals(new int[]{}, emptyArray);
    }

    @Test
    public void radixSort_SingleElementArray_NoChange() {
        int[] singleElementArray = {42};
        Play.radixSort(singleElementArray);
        assertArrayEquals(new int[]{42}, singleElementArray);
    }

    @Test
    public void radixSort_AllSameElements_Sorted() {
        int[] sameElementsArray = {5, 5, 5, 5};
        Play.radixSort(sameElementsArray);
        assertArrayEquals(new int[]{5, 5, 5, 5}, sameElementsArray);
    }

    @Test
    public void radixSort_RandomNumbers_Sorted() {
        int[] randomNumbers = {170, 45, 75, 90, 802, 24, 2, 66};
        Play.radixSort(randomNumbers);
        assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, randomNumbers);
    }

    @Test
    public void radixSort_MaxDigits_Sorted() {
        int[] maxDigitsArray = {99999, 10000, 1000, 100, 10, 1};
        Play.radixSort(maxDigitsArray);
        assertArrayEquals(new int[]{1, 10, 100, 1000, 10000, 99999}, maxDigitsArray);
    }

    @Test
    public void radixSort_NegativeNumbers_NoChange() {
        int[] negativeNumbers = {-1, -2, -3, -4};
        Play.radixSort(negativeNumbers);
        assertArrayEquals(new int[]{-4, -3, -2, -1}, negativeNumbers);
    }
}
