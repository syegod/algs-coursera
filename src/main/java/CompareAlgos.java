import edu.princeton.cs.algs4.Stopwatch;
import module4.InsertionSort;
import module5.MergeSort;
import module6.QuickSort;

import java.util.Random;

public class CompareAlgos {
    public static void main(String[] args) {
        int[] arr1000 = genArray(1000);
        int[] arr100000 = genArray(100000);

        insertionTime(arr1000);
        quickTime(arr1000);
        mergeTime(arr1000);

        insertionTime(arr100000);
        quickTime(arr100000);
        mergeTime(arr100000);
    }

    public static void insertionTime(int[] arr) {
        Stopwatch start = new Stopwatch();
        InsertionSort.sort(arr);
        System.out.println("Insertion sort: " + arr.length + " items elapsed time: " + start.elapsedTime());
    }

    public static void mergeTime(int[] arr) {
        Stopwatch start = new Stopwatch();
        MergeSort.mergeSort(arr);
        System.out.println("Merge sort: " + arr.length + " items elapsed time: " + start.elapsedTime());
    }

    public static void quickTime(int[] arr) {
        Stopwatch start = new Stopwatch();
        QuickSort.quicksort(arr);
        System.out.println("Quicksort: " + arr.length + " items elapsed time: " + start.elapsedTime());
    }

    private static int[] genArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(0, n * 2);
        }
        return arr;
    }
}
