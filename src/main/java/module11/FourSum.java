package module11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FourSum {
    public static void main(String[] args) {
        int[] a = {3, 4, 7, 1, 2, 9, 8};

        if (hasFourSum(a)) {
            System.out.println("4-SUM exists.");
        } else {
            System.out.println("No 4-SUM found.");
        }
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean hasFourSum(int[] a) {
        Map<Integer, List<Pair>> sumMap = new HashMap<>();

        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = a[i] + a[j];

                if (sumMap.containsKey(sum)) {
                    for (Pair pair : sumMap.get(sum)) {
                        int k = pair.first;
                        int l = pair.second;

                        if (k != i && k != j && l != i && l != j) {
                            return true;
                        }
                    }
                }

                sumMap.computeIfAbsent(sum, key -> new ArrayList<>()).add(new Pair(i, j));
            }
        }

        return false;
    }
}

