package module3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueWithTwoStacksTest {
    @Test
    void testEnqueueDequeue() {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        queue.enqueue(5);
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
    }

}