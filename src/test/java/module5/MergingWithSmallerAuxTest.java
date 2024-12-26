package module5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


import static module5.MergingWithSmallerAux.mergeTwoArrays;

class MergingWithSmallerAuxTest {

    @Test
    void testMergeTwoArrays() {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(Arrays.toString(expected), Arrays.toString(mergeTwoArrays(arr)));
    }

}