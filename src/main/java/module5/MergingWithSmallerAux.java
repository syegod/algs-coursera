package module5;

public class MergingWithSmallerAux {

    public static int[] mergeTwoArrays(int[] arr) {
        int mid = arr.length / 2;
        int[] aux = new int[mid];
        System.arraycopy(arr, 0, aux, 0, mid);
        int l = 0, k = 0;
        while (l < aux.length && mid < arr.length) {
            if (aux[l] <= arr[mid]) {
                arr[k++] = aux[l++];
            } else {
                arr[k++] = arr[mid++];
            }
        }
        while (l < aux.length) {
            arr[k++] = aux[l++];
        }
        while (mid < arr.length) {
            arr[k++] = arr[mid++];
        }
        return arr;
    }
}
