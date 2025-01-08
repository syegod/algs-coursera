package module6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankOfKeyTest {
    @Test
    void testRankOfKey() {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        int expected = 6;
        int key = 5;

        assertEquals(expected, RankOfKey.findKeyRank(a, b, key));
    }

}