package com.ycj.b_search;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class B_InsertSearchTest {

    private B_InsertSearch search;

    @Before
    public void setUp() {
        search = new B_InsertSearch();
    }

    @Test
    public void doSearch_EmptyArray_ReturnsNegativeOne() {
        int[] arr = {};
        int target = 5;
        int result = search.doSearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void doSearch_SingleElementArray_TargetPresent_ReturnsIndexZero() {
        int[] arr = {5};
        int target = 5;
        int result = search.doSearch(arr, target);
        assertEquals(0, result);
    }

    @Test
    public void doSearch_TargetPresent_ReturnsCorrectIndex() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int result = search.doSearch(arr, target);
        assertEquals(2, result);
    }

    @Test
    public void doSearch_TargetNotPresent_ReturnsNegativeOne() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;
        int result = search.doSearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void doSearch_TargetAtStart_ReturnsIndexZero() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 1;
        int result = search.doSearch(arr, target);
        assertEquals(0, result);
    }

    @Test
    public void doSearch_TargetAtEnd_ReturnsLastIndex() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        int result = search.doSearch(arr, target);
        assertEquals(4, result);
    }

    @Test
    public void doSearch_DuplicateValues_ReturnsFirstOccurrenceIndex() {
        int[] arr = {1, 2, 2, 3, 4};
        int target = 2;
        int result = search.doSearch(arr, target);
        assertEquals(1, result);
    }
}
