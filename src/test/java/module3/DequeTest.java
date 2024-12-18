package module3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    @Test
    void testAddFirstRemoveFirst() {
       var d = new Deque<>();
       d.addFirst(1);
       assertEquals(1, d.size());
       assertEquals(1, d.removeFirst());
       assertEquals(0, d.size());
        assertTrue(d.isEmpty());
    }

    @Test
    void testAddLastRemoveLast() {
        var d = new Deque<>();
        d.addLast(1);
        assertEquals(1, d.size());
        assertEquals(1, d.removeLast());
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
    }

    @Test
    void testMultipleAddRemove() {
        var d = new Deque<>();
        d.addLast(1);
        d.addLast(2);
        d.addFirst(3);
        d.addLast(4);
        assertEquals(4, d.size());
        assertEquals(4, d.removeLast());
        assertEquals(3, d.removeFirst());
        assertEquals(2, d.size());
    }

}