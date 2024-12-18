package module3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void testPushAndPeek() {
        StackMax<Integer> ints = new StackMax<>();
        ints.push(1);
        ints.push(2);
        ints.push(4);
        assertEquals(4, ints.peek());
    }

    @Test
    void testPop() {
        StackMax<Integer> ints = new StackMax<>();
        ints.push(1);
        ints.push(2);
        ints.push(4);
        assertEquals(4, ints.pop());
        assertEquals(2, ints.peek());
    }

    @Test
    void testEmpty() {
        StackMax<Integer> ints = new StackMax<>();
        ints.push(1);
        ints.push(2);
        ints.push(4);
        ints.pop();
        ints.pop();
        ints.pop();
        assertTrue(ints.empty());
    }

    @Test
    void testMax() {
        StackMax<Integer> ints = new StackMax<>();
        ints.push(1);
        ints.push(4);
        ints.push(2);
        assertEquals(4, ints.getMax());
    }

    @Test
    void testMaxAfterPop() {
        StackMax<Integer> ints = new StackMax<>();
        ints.push(1);
        ints.push(2);
        ints.push(3);
        ints.push(5);
        ints.push(4);
        ints.push(4);
        ints.push(12);
        assertEquals(12, ints.getMax());
        ints.pop();
        assertEquals(5, ints.getMax());
    }
}