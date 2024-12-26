package module4;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;
import java.util.Random;

import static utils.Utils.genArray;


public class SelectionSort {

    public static int[] sort(int[] nums) {
        for (var i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (var j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            var temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}