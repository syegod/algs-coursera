package module4;

import org.junit.jupiter.api.Test;

import static module4.TwoSetsIntersec.*;
import static org.junit.jupiter.api.Assertions.*;

class TwoSetsIntersecTest {
    @Test
    void testTwoSetsIntersectionWithSets() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        assertEquals(3, intersectionWithSets(arr1, arr2));
    }

    @Test
    void testTwoSetsIntersection() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        assertEquals(3, intersection(arr1, arr2));
    }

}