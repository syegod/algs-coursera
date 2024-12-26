package module2;

public class BitonicSearch {
    public static boolean bitonicHas(int[] arr, int target) {
        int peak = findPeak(arr);
        return binarySearchReverse(arr, target, peak, arr.length - 1) || binarySearch(arr, target, 0, peak);
    }

    public static boolean binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    private static boolean binarySearchReverse(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && (arr[mid] < arr[mid + 1])) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}


