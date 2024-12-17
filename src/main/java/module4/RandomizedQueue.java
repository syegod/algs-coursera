package module4;

// A randomized queue is similar to a stack or queue, except that the
// item removed is chosen uniformly at random among items in the data structure.

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> first, last;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (last == null) {
            var newNode = new Node<>(item, null, null);
            first = newNode;
            last = newNode;
            return;
        }
        var newNode = new Node<>(item, null, last);
        last.next = newNode;
        last = newNode;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIndex = StdRandom.uniformInt(0, size);
        size--;
        if (randomIndex == 0) {
            Item value = first.value;
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first = first.next;
            }
            return value;
        }
        int count = 1;
        var node = first;
        while (count < randomIndex) {
            node = node.next;
            count++;
        }
        Item value = node.value;
        node.next = node.prev;
        return value;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIndex = StdRandom.uniformInt(0, size);
        if (randomIndex == 0) {
            return first.value;
        }
        int count = 1;
        var node = first;
        while (count < randomIndex) {
            node = node.next;
            count++;
        }
        return node.value;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator<>();
    }

    // unit testing (required)

    public static void main(String[] args) {
        var q = new RandomizedQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
//        System.out.println(q.size());
//        System.out.println(q.dequeue());
//        System.out.println(q.size());
//        System.out.println(q.sample());
//        System.out.println(q.isEmpty());

        for (var i : q) {
            System.out.println(i);
        }

    }

    private class RandomizedIterator<Item> implements Iterator<Item> {
        private Object[] items;
        private int currentIndex;

        public RandomizedIterator() {
            items = new Object[size];
            currentIndex = 0;
            var node = first;
            int i = 0;
            while (node != null) {
                items[i] = node.value;
                node = node.next;
                i++;
            }
            StdRandom.shuffle(items);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < items.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (Item) items[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<Item> {

        Item value;
        Node<Item> next, prev;

        public Node(Item value, Node<Item> next, Node<Item> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}