package module6;

import module4.IsPermutation;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void testQuickSort() {
        int[] arr = Utils.genArray(10000);
        int[] sorted = Arrays.copyOf(arr, arr.length);
        QuickSort.quicksort(sorted);

        assertTrue(Utils.isSorted(sorted));
        assertTrue(IsPermutation.isPermutation(arr, sorted));
    }

}