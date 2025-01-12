package module7;

import java.util.ArrayList;
import java.util.List;

public class TaxicabNumbers {
    public static void main(String[] args) {
        System.out.println(findNumbers(100000));
    }

    public static List<Integer> findNumbers(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1729; i <= n; i++) {
            if (isTaxicab(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isTaxicab(int n) {
        List<int[]> res = new ArrayList<>();
        int N = (int) Math.cbrt(n);
        for (int i = 1; i < N; i++) {
            if (res.size() == 2) {
                return true;
            }
            int cubI = (int) Math.pow(i, 3);
            for (int j = i+1; j <= N; j++) {
                int cubJ = (int) Math.pow(j, 3);
                if (cubI + cubJ == n && isFreeToTake(j, i, res)) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res.size() == 2;
    }


    private static boolean isFreeToTake(int n1, int n2, List<int[]> arrays) {
        for (int[] i : arrays) {
            for (var j : i) {
                if (n1 == j || n2 == j) {
                    return false;
                }
            }
        }
        return true;
    }

}
