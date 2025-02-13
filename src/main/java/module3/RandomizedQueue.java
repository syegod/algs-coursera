package module3;

// A randomized queue is similar to a stack or queue, except that the
// item removed is chosen uniformly at random among items in the data structure.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

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
        if (size == 1) {
            size--;
            Item value = first.value;
            first = null;
            last = null;
            return value;
        }
        int randomIndex = StdRandom.uniformInt(1, size);
        size--;
        if (randomIndex == 0) {
            Item value = first.value;
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.prev = null;
            }
            return value;
        }
        int count = 1;
        var node = first.next;
        while (count < randomIndex) {
            node = node.next;
            count++;
        }
        Item value = node.value;

        if (node == last) {
            last = last.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

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
        var queue = new RandomizedQueue<>();
        queue.enqueue(733);
        queue.enqueue(185);
        queue.enqueue(129);
        queue.enqueue(79);
        queue.enqueue(250);
        queue.dequeue();
        for (var i : queue) {
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