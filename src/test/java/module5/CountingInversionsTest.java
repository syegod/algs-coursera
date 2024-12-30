package module5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingInversionsTest {
    @Test
    void testCountInversions() {
        int[] arr = {1, 2, 3, 5, 4, 7, 6, 9, 8};

        assertEquals(3, CountingInversions.countInversions(arr));
    }

}