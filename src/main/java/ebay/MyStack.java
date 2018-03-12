package ebay;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {

    private Object[] array;
    private int idx = -1;

    public MyStack() {
        array = new Object[2];
    }

    public MyStack(int size) {
        array = new Object[size];
    }

    public T peek() {
        if (idx == -1)
            throw new EmptyStackException();

        return (T)array[idx];
    }

    public T pop() {
        if (idx == -1)
            throw new EmptyStackException();

        return (T)array[idx--];
    }

    public T push(T e) {
        checkSize();
        array[++idx] = e;
        return e;
    }

    private void checkSize() {
        if (idx + 1 == array.length) {
            array = Arrays.copyOf(array, 2 * array.length);
        }
    }

    public boolean isEmpty() {
        return idx == -1;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("陈".equals("陈"));
    }
}
