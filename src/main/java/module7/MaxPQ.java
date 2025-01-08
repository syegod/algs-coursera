package module7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxPQ<T extends Comparable<T>> {
    private Object[] arr;
    private int size;

    public MaxPQ() {
        this.arr = new Object[16];
        this.size = 0;
    }


    public void insert(T item) {
        if (size == 0) {
            arr[++size] = item;
        } else {
            if (arr.length-1 == size) {
                resize();
            }
            arr[++size] = item;
            swim(size);
        }
    }


    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= size) {
            int j = k * 2;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (j < k) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        var t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T elem = (T) arr[1];
        exch(1, size--);
        sink(1);
        arr[size + 1] = null;
        return elem;
    }

    public int size() {
        return size;
    }

    private boolean less(int i, int j) {
        return ((T) arr[i]).compareTo((T) arr[j]) < 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        if (size > 0) {
            int i = 1;
            while ( i < arr.length && arr[i] != null) {
                arr[i] = null;
            }
            size = 0;
        }
    }

    private void resize() {
        arr = Arrays.copyOf(arr, arr.length * 2);
    }
}
