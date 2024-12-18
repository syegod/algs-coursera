package module3;

public class StackMax<E extends Comparable<E>> {
    private static final int INITIAL_CAPACITY = 16;
    private Object[] array;
    private int size;
    private E max;

    public StackMax() {
        array = new Object[16];
        size = 0;
        max = null;
    }

    public void push(E item) {
        if (size == array.length) {
            resize();
        }
        if (max != null) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        } else {
            max = item;
        }
        array[size++] = item;
    }

    public E pop() {
        if (size != 0) {
            E item = (E) array[--size];
            array[size] = null;
            if (max.equals(item)) {
                findNewMax();
            }
            return item;
        } else {
            return null;
        }
    }

    private void findNewMax() {
        E newMax = (E) array[0];
        for (int i = 0; i < size; i++) {
            if (newMax.compareTo((E) array[i]) < 0) {
                newMax = (E) array[i];
            }
        }
        max = newMax;
    }

    public E peek() {
        return (E) array[size - 1];
    }

    public E getMax() {
        return max;
    }

    public boolean empty() {
        return size == 0;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
