package module2;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = generateArray(8000, -80000, 80000);
        int[] sortedArr = sort(arr);
//        System.out.println(Arrays.toString(sortedArr));
        System.out.println(threeSum(sortedArr, 0));
    }

    static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    static int threeSum(int[] arr, int num) {
        Stopwatch start = new Stopwatch();
        int count = 0;
        if (arr.length < 3) {
            return -1;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == num && (arr[i] != arr[j] && arr[j] != arr[k])) {
                        count++;
//                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
//        System.out.println(start.elapsedTime());
        return count;
    }

    public static int[] generateArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            int randInt = rand.nextInt((max - min) + 1) + min;
            if (!contains(array, randInt)) {
                array[i] = randInt;
            }
        }

        return array;
    }

    static boolean contains(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) return true;
        }
        return false;
    }
}
