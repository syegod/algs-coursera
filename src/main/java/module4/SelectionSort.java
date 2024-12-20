package module4;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
//        StdRandom.shuffle(arr);
        int[] arr = genArr(100000);
        Stopwatch start = new Stopwatch();
        arr = sort(arr);
        double elapsedTime = start.elapsedTime();
        System.out.println("array after = " + Arrays.toString(arr));
        System.out.println(elapsedTime);
    }

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

    public static int[] genArr(int N) {
        int[] arr = new int[N];
        Random rand = new Random(314L);
        for (var i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((N * N) * -1, N*N);
        }
        return arr;
    }
}