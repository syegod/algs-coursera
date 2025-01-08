package module7;

import java.util.PriorityQueue;

public class DynamicMedian {
    private final PriorityQueue<Integer> maxpq;
    private final PriorityQueue<Integer> minpq;

    public DynamicMedian() {
        maxpq = new PriorityQueue<>((a, b) -> b - a);
        minpq = new PriorityQueue<>();
    }

    public void insert(int num) {
        if (maxpq.isEmpty() || num < maxpq.peek()) {
            maxpq.add(num);
        } else {
            minpq.add(num);
        }

        if (maxpq.size() > minpq.size() + 1) {
            minpq.add(maxpq.poll());
        }
        if (minpq.size() > maxpq.size()) {
            maxpq.add(minpq.poll());
        }
    }

    public int findMedian() {
        return maxpq.peek();
    }

    public void removeMedian() {
        maxpq.poll();

        if (maxpq.size() < minpq.size()) {
            maxpq.add(minpq.poll());
        }
    }
}
