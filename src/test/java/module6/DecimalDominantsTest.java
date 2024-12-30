package module6;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DecimalDominantsTest {
    @Test
    void testDecimalDominants() {
        int[] arr = Utils.genArray(10000);
        System.out.println(DecimalDominants.findDominants(arr));
    }

}