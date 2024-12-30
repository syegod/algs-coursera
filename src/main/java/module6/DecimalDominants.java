package module6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecimalDominants {

    public static List<Integer> findDominants(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.compute(i, (k,v) -> v == null ? 1 : v + 1);
        }

        for (var kv: map.entrySet()) {
            int val = kv.getValue();
            if (val >= arr.length / 10) {
                result.add(kv.getKey());
            }
        }
        return result;
    }
}
