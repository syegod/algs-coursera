package module6;

public class RankOfKey {
    public static int findKeyRank(int[] a, int[] b, int k) {
        if (a.length == 0) {
            return b[k];
        }
        if (b.length == 0) {
            return a[k];
        }

        int midA = a.length / 2;
        int midB = b.length / 2;

        if (midA + midB < k) {
            if (a[midA] < b[midB]) {
                return findKeyRank(subArray(a, midA + 1), b, k - midA - 1);
            } else {
                return findKeyRank(a, subArray(b, midB + 1), k - midB - 1);
            }
        } else {
            if (a[midA] < b[midB]) {
                return findKeyRank(a, subArray(b, 0, midB), k);
            } else {
                return findKeyRank(subArray(a, 0, midA), b, k);
            }
        }
    }

    private static int[] subArray(int[] array, int start) {
        int[] result = new int[array.length - start];
        System.arraycopy(array, start, result, 0, result.length);
        return result;
    }

    private static int[] subArray(int[] array, int start, int end) {
        int[] result = new int[end - start];
        System.arraycopy(array, start, result, 0, result.length);
        return result;
    }
}
