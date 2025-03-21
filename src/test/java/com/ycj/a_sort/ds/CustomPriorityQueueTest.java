package com.ycj.a_sort.ds;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CustomPriorityQueueTest {

    private CustomPriorityQueue maxHeap;
    private CustomPriorityQueue minHeap;

    @Before
    public void setUp() {
        maxHeap = new CustomPriorityQueue(5, true);
        minHeap = new CustomPriorityQueue(5, false);
    }

    @Test
    public void insert_QueueFull_ThrowsException() {
        CustomPriorityQueue fullQueue = new CustomPriorityQueue(1);
        fullQueue.insert(1);
        assertThrows(RuntimeException.class, () -> fullQueue.insert(2));
    }

    @Test
    public void insert_MaxHeap_MaintainsHeapProperty() {
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        assertEquals(20, maxHeap.peek()); // 根节点应为最大值
    }

    @Test
    public void insert_MinHeap_MaintainsHeapProperty() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        assertEquals(5, minHeap.peek()); // 根节点应为最小值
    }

    @Test
    public void insert_EmptyQueue_InsertsCorrectly() {
        maxHeap.insert(10);
        assertEquals(10, maxHeap.peek()); // 唯一的元素应为根节点
    }

    @Test
    public void insert_SingleElement_HeapPropertyUnchanged() {
        maxHeap.insert(10);
        maxHeap.insert(5);
        assertEquals(10, maxHeap.peek()); // 根节点应保持最大值
    }

    @Test
    public void peek_EmptyQueue_ThrowsException() {
        assertThrows(RuntimeException.class, () -> maxHeap.peek());
    }

    @Test
    public void peek_NonEmptyQueue_ReturnsRoot() {
        maxHeap.insert(10);
        assertEquals(10, maxHeap.peek());
    }

    @Test
    public void delete_EmptyQueue_ThrowsException() {
        assertThrows(RuntimeException.class, () -> maxHeap.delete());
    }

    @Test
    public void delete_NonEmptyQueue_RemovesAndMaintainsHeapProperty() {
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        assertEquals(20, maxHeap.delete()); // 删除最大值
        assertEquals(10, maxHeap.peek()); // 新的根节点应为下一个最大值
    }

    @Test
    public void delete_MinHeap_RemovesAndMaintainsHeapProperty() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        assertEquals(5, minHeap.delete()); // 删除最小值
        assertEquals(10, minHeap.peek()); // 新的根节点应为下一个最小值
    }
}
