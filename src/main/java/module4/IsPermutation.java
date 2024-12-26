package module4;

import java.util.Arrays;

public class IsPermutation {

    public static boolean isPermutation(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (var i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
