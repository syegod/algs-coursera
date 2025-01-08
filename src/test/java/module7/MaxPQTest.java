package module7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPQTest {
    @Test
    void testInsert() {
        MaxPQ<Integer> pq = new MaxPQ<>();
        pq.insert(1);

        assertFalse(pq.isEmpty());
        assertEquals(1, pq.size());
    }

    @Test
    void testRemove() {
        MaxPQ<Integer> pq = new MaxPQ<>();
        pq.insert(1);

        assertEquals(1, pq.remove());
        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());
    }

    @Test
    void testMultiInsertRemove() {
        MaxPQ<Integer> pq = new MaxPQ<>();
        pq.insert(8);
        pq.insert(4);
        pq.insert(18);
        pq.insert(3);
        pq.insert(6);
        pq.insert(5);
        pq.insert(9);
        pq.insert(7);

        assertEquals(8, pq.size());
        assertEquals(18, pq.remove());
        assertEquals(9, pq.remove());

        pq.insert(12);

        assertEquals(7, pq.size());
        assertEquals(12, pq.remove());
    }

    @Test
    void testClear() {
        MaxPQ<Integer> pq = new MaxPQ<>();
        pq.insert(8);
        pq.insert(4);
        pq.insert(18);
        pq.insert(3);
        pq.insert(6);
        pq.insert(5);
        pq.insert(9);
        pq.insert(7);

        pq.clear();
        assertEquals(0, pq.size());
    }

    @Test
    void TestResize() {
        MaxPQ<Integer> pq = new MaxPQ<>();
        for (int i = 0; i < 100; i++) {
            pq.insert(i);
        }

        assertEquals(100, pq.size());   // Ожидаем, что размер кучи будет 100
        assertEquals(99, pq.remove());  // Ожидаем, что максимальный элемент будет 99
    }
}