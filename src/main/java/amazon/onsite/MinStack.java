package amazon.onsite;

import java.util.Stack;

public class MinStack {

    Stack<Integer> nums = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        nums.push(x);

        if (min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    public void pop() {
        if (!nums.isEmpty()) {
            if (min.peek() == top())
                min.pop();
            nums.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();
    }
}
