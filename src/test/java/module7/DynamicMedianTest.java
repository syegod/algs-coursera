package module7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicMedianTest {
    @Test
    void testFindMedian() {
        DynamicMedian median = new DynamicMedian();
        for (int i = 1; i <= 100; i++) {
            median.insert(i);
        }

        assertEquals(50, median.findMedian());
    }

    @Test
    void testRemoveMedian() {
        DynamicMedian median = new DynamicMedian();
        for (int i = 1; i <= 100; i++) {
            median.insert(i);
        }
        median.removeMedian();
        assertEquals(51, median.findMedian());
    }

}