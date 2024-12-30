package module5;

public class CountingInversions {
    public static int mergeAndCount(int[] arr, int[] tempArr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int invCount = 0;

        invCount += mergeAndCount(arr, tempArr, left, mid);
        invCount += mergeAndCount(arr, tempArr, mid + 1, right);

        invCount += merge(arr, tempArr, left, mid, right);

        return invCount;
    }

    public static int merge(int[] arr, int[] tempArr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
                invCount += (mid - i + 1); // All elements from arr[i] to arr[mid] are greater than arr[j]
            }
        }

        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }

        while (j <= right) {
            tempArr[k++] = arr[j++];
        }

        System.arraycopy(tempArr, left, arr, left, right - left + 1);

        return invCount;
    }

    public static int countInversions(int[] arr) {
        int[] tempArr = new int[arr.length];
        return mergeAndCount(arr, tempArr, 0, arr.length - 1);
    }
}
