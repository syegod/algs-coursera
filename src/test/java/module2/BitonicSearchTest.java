package module2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitonicSearchTest {
    @Test
    void testBitonic() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int target = 8;

        assertTrue(BitonicSearch.bitonicHas(arr, target));
    }

    @Test
    void testBitonicCorner() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int target1 = 1;
        int target2 = 2;

        assertTrue(BitonicSearch.bitonicHas(arr, target1));
        assertTrue(BitonicSearch.bitonicHas(arr, target2));

    }

    @Test
    void testFindPeak() {
        int[] arr = {1, 3, 8, 12, 4, 2};

        assertEquals(3, BitonicSearch.findPeak(arr));
    }

    @Test
    void testBinarySearch() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int target = 8;

        assertTrue(BitonicSearch.binarySearch(arr, 8, 0, arr.length-1));
    }
}