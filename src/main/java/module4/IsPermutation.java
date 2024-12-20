package module4;

import java.util.Arrays;

public class IsPermutation {
    public static void main(String[] args) {
        int[] a = {9, 18, 17, 1, -12, 4, 6};
        int[] b = {17, -12, 9, 1, 18, 6, 6};
        System.out.println(isPermutation(a, b));
    }

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
