package com.ycj.b_search;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class A_BinarySearchTest {

    private A_BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new A_BinarySearch();
    }

    @Test
    public void doSearch_EmptyArray_ReturnsNegativeOne() {
        int[] arr = {};
        int target = 5;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void doSearch_SingleElementArray_TargetExists_ReturnsIndex() {
        int[] arr = {5};
        int target = 5;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(0, result);
    }

    @Test
    public void doSearch_SingleElementArray_TargetDoesNotExist_ReturnsNegativeOne() {
        int[] arr = {5};
        int target = 10;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void doSearch_MultipleElementsArray_TargetExists_ReturnsIndex() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(2, result);
    }

    @Test
    public void doSearch_MultipleElementsArray_TargetDoesNotExist_ReturnsNegativeOne() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void doSearch_TargetLessThanMinimum_ReturnsNegativeOne() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 0;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void doSearch_TargetGreaterThanMaximum_ReturnsNegativeOne() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;
        int result = binarySearch.doSearch(arr, target);
        assertEquals(-1, result);
    }
}
