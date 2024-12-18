package module3;

// A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports
// adding and removing items from either the front or the back of the data structure.

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first, last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (first == null) {
            var newNode = new Node<>(item, null, null);
            first = newNode;
            last = newNode;
            return;
        }
        var newNode = new Node<>(item, first, null);
        first.prev = newNode;
        first = newNode;
    }

    // add the item to the back
    public void addLast(Item item) {
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


    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        var item = first;
        size--;
        if (first.next != null) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
            last = null;
        }
        return item.value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        var item = last;
        size--;
        if (last.prev != null) {
            last = last.prev;
            last.next = null;
        } else {
            first = null;
            last = null;
        }
        return item.value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item val = currentNode.value;
                currentNode = currentNode.next;
                return val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println(deque);
        deque.addLast(1);
        deque.addFirst(2);
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.iterator());
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
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
