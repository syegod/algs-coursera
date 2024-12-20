package module4;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

import static module4.SelectionSort.genArr;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = genArr(100000);
        Stopwatch start = new Stopwatch();
        arr = sort(arr);
        double elapsedTime = start.elapsedTime();
        System.out.println(Arrays.toString(arr));
        System.out.println(elapsedTime);
    }

    public static int[] sort(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
            for (var j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    var temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return nums;
    }
}
