package module6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NutsAndBolts {


    public static List<int[]> sortNutsAndBolts(int[] nuts, int[] bolts) {
        var list = new ArrayList<int[]>();
        Arrays.sort(nuts);
        for (int i : bolts) {
            int[] nutboltPair = new int[2];
            nutboltPair[0] = i;
            int left = 0, right = nuts.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nuts[mid] == i) {
                    nutboltPair[1] = nuts[mid];
                    break;
                } else if (nuts[mid] < i) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            list.add(nutboltPair);
        }
        return list;
    }


}
