package module4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSetsIntersec {

    public static int intersectionWithSets(int[] a, int[] b) {
        Set<Integer> ints1 = new HashSet<>();
        Set<Integer> ints2 = new HashSet<>();
        for (var i = 0; i < a.length; i++) {
            ints1.add(a[i]);
            ints2.add(b[i]);
        }

        ints1.retainAll(ints2);
        System.out.println(ints1);
        return ints1.size();
    }


    public static int intersection(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int counter = 0;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                counter++;
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return counter;
    }

}
