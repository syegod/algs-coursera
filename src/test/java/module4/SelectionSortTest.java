package module4;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void testSelectionSort() {
        int[] arr = Utils.genArray(10000);
        int[] sorted = SelectionSort.sort(Arrays.copyOf(arr, arr.length));
        assertTrue(Utils.isSorted(sorted));
        assertTrue(IsPermutation.isPermutation(arr, sorted));
    }

}