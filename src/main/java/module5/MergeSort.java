package module5;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        int l = arr.length;
        if (l < 2) {
            return;
        }

        int mid = l / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[l - mid];
        for (var i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }
        for (var i = mid; i < l; i++) {
            rightHalf[i - mid] = arr[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(arr, leftHalf, rightHalf);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }

}
