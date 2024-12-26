package module4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IsPermutationTest {
    @Test
    void testIsPermutationFalse() {
        int[] a1 = {9, 18, 17, 1, -12, 4, 6};
        int[] b1 = {17, -12, 9, 1, 18, 6, 6};

        int[] a2 = {4, 48, 11, 6, 18, 3, 5};
        int[] b2 = {48, 4, 3, 5, 6, 11, 18};

        assertFalse(IsPermutation.isPermutation(a1, b1));
        assertTrue(IsPermutation.isPermutation(a2, b2));
    }
}