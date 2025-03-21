package com.ycj.a_sort.ds;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CustomPriorityQueueTest {

    private CustomPriorityQueue priorityQueue;

    @Before
    public void setUp() {
        priorityQueue = new CustomPriorityQueue(5);
    }

    @Test
    public void insert_WhenQueueIsFull_ShouldThrowException() {
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        priorityQueue.insert(4);
        priorityQueue.insert(5);

        assertThrows(RuntimeException.class, () -> priorityQueue.insert(6));
    }

    @Test
    public void insert_WhenQueueIsNotFull_ShouldInsertSuccessfully() {
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);

        assertEquals(3, priorityQueue.delete());
        assertEquals(2, priorityQueue.delete());
        assertEquals(1, priorityQueue.delete());
    }

    @Test
    public void delete_WhenQueueIsEmpty_ShouldThrowException() {
        assertThrows(RuntimeException.class, priorityQueue::delete);
    }

    @Test
    public void delete_WhenQueueIsNotEmpty_ShouldDeleteMaxValue() {
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);

        assertEquals(3, priorityQueue.delete());
        assertEquals(2, priorityQueue.delete());
        assertEquals(1, priorityQueue.delete());
    }
}
