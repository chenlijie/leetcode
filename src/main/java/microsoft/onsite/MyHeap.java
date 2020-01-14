package microsoft.onsite;

import java.util.Comparator;

public class MyHeap<T> {

    private int capacity;
    private Object[] heap;
    private int size = 0;
    private Comparator<T> comparator;

    public MyHeap() {
        capacity = 4;
        heap = new Object[capacity];
    }

    public MyHeap(int capacity) {
        this.capacity = capacity;
        heap = new Object[capacity];
    }

    public MyHeap(int capacity, Comparator<T> comparator) {
        this.capacity = capacity;
        heap = new Object[capacity];
        this.comparator = comparator;
    }

    public void offer(T t) {
        if (size == capacity)
            resize();

        if (comparator == null)
            siftUp(size, t);
        else
            siftUpWithComparator(size, t);

        size++;
    }

    public T peek() {
        if (size == 0)
            return null;
        else
            return (T)heap[0];
    }

    public T poll() {
        if (size == 0)
            throw new NullPointerException();

        T t = (T) heap[0];
        heap[0] = heap[--size];
        siftDown(0, (T)heap[0]);

        return t;
    }

    public boolean remove(T t) {
        int idx = -1;

        for (int i = 0; i < size; i++) {
            if (heap[i].equals(t)) {
                idx = i;
                break;
            }
        }

        heap[idx] = heap[--size];
        if (comparator == null)
            siftDown(idx, (T)heap[idx]);
        else
            siftDownWithComparator(idx, (T)heap[idx]);

        return idx != -1;
    }

    private void siftDown(int idx, T t) {
        Comparable<T> key = (Comparable<T>)t;

        while (idx < size) {
            int c = (idx << 1) + 1;
            int right = c + 1;

            if (c < size && right < size && ((Comparable<T>)heap[c]).compareTo((T)heap[right]) > 0)
                c = right;

            if (c >= size || key.compareTo((T)heap[c]) <= 0)
                break;

            heap[idx] = heap[c];
            idx = c;
        }

        heap[idx] = t;
    }

    private void siftDownWithComparator(int idx, T t) {
        while (idx < size) {
            int c = (idx << 1) + 1;
            int right = c + 1;

            if (c < size && right < size && comparator.compare((T) heap[c], (T) heap[right]) > 0)
                c = right;

            if (c >= size || comparator.compare(t, (T)heap[c]) > 0)
                break;

            heap[idx] = heap[c];
            idx = c;
        }

        heap[idx] = t;
    }

    private void resize() {
        Object[] old = heap;
        capacity = capacity << 1;
        heap = new Object[capacity];

        for (int i = 0; i < size; i++) {
            heap[i] = old[i];
        }
    }

    private void siftUp(int idx, T t) {
        Comparable<? super T> key = (Comparable<T>)t;

        while (idx > 0) {
            int p = idx >> 1;
            T parent = (T)heap[p];

            if (key.compareTo(parent) >= 0)
                break;

            heap[idx] = parent;
            idx = p;
        }

        heap[idx] = t;
    }

    private void siftUpWithComparator(int idx, T t) {

        while (idx > 0) {
            int p = idx >> 1;
            T parent = (T)heap[p];

            if (comparator.compare(t, parent) >= 0)
                break;

            heap[idx] = parent;
            idx = p;
        }

        heap[idx] = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyHeap<Integer> heap = new MyHeap<>(4, Comparator.<Integer>reverseOrder());
        heap.offer(6);
        heap.offer(3);
        heap.offer(4);
        heap.offer(1);
        heap.offer(5);
        heap.offer(8);
        heap.offer(7);

//        System.out.println(heap.poll());
//        System.out.println(heap.peek());

//        heap.remove(4);
//        heap.remove(3);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
