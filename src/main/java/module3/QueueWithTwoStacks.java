package module3;

import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int size;

    public QueueWithTwoStacks() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(int val) {
        if (!stack2.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        size++;
        stack1.push(val);
    }

    public int dequeue() {
        if (!stack1.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }

    public int getSize() {
        return size;
    }
}



