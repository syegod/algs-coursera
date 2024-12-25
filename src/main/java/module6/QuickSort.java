package module6;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 11, 1, 4, 6, 7, 3, 2, 5, 15};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);
        sort(arr, left, index - 1);
        sort(arr, index, right);
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

//    private static void sort(int[] arr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//
//        int p = arr[(left + right) / 2];
//        int index = partition(arr, left, right, p);
//        sort(arr, left, index - 1);
//        sort(arr, index, right);
//    }
//
//    private static int partition(int[] arr, int left, int right, int pivot) {
//        while (left <= right) {
//            while (arr[left] < pivot) {
//                left++;
//            }
//            while (arr[right] > pivot) {
//                right--;
//            }
//
//            if (left <= right) {
//                swap(arr, left, right);
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }
//
//    private static void swap(int[] arr, int left, int right) {
//        int temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//    }
}
