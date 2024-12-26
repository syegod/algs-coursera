package module4;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DutchNationalFlagTest {

    @Test
    void testSortColors() {
        int[] arr = {0, 0, 0, 2, 1, 2, 2, 1, 0, 2, 1, 1};
        int[] sorted = Arrays.copyOf(arr, arr.length);
        DutchNationalFlag.sortColors(sorted);

        System.out.println(Arrays.toString(sorted));
        assertTrue(Utils.isSorted(sorted));
//        assertTrue(IsPermutation.isPermutation(arr, sorted));
    }

}