package module6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NutsAndBoltsTest {
    @Test
    void testNutsAndBolts() {
        int[] nuts = {5, 1, 7, 4, 9, 17, 36};
        int[] bolts = {7, 17, 36, 4, 9, 5, 1};
        List<int[]> actual = NutsAndBolts.sortNutsAndBolts(nuts, bolts);

        List<int[]> expected = new ArrayList<>(List.of(
                new int[]{5, 5},
                new int[]{7, 7},
                new int[]{17, 17},
                new int[]{36, 36},
                new int[]{1, 1},
                new int[]{4, 4},
                new int[]{9, 9}
        ));

        // Сортируем оба списка
        expected.sort(Comparator.comparingInt(a -> a[0]));
        actual.sort(Comparator.comparingInt(a -> a[0]));

        // Сравниваем каждый элемент внутри списков
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(Arrays.equals(expected.get(i), actual.get(i)), "Mismatch at index " + i);
        }
    }

}