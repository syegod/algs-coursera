package module4;

// colors: 0-red
//         1-white
//         2-blue
public class DutchNationalFlag {
    public static int[] sortColors(int[] buckets) {
        int low = 0, mid = 0;
        int high = buckets.length - 1;

        while (mid <= high) {
            if (buckets[mid] == 0) {
                swap(buckets, low, mid);
                low++;
                mid++;
            } else if (buckets[mid] == 1) {
                mid++;
            } else {
                swap(buckets, mid, high);
                high--;
            }
        }

        return buckets;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


