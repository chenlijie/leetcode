package ebay;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {

    private static final int DEFAULT_SIZE = 3;
    private final int capacity;
    private final Object[] items;

    private int count = 0;
    private int putIdx = 0;
    private int takeIdx = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public MyBlockingQueue() {
        capacity = DEFAULT_SIZE;
        items = new Object[DEFAULT_SIZE];
    }

    public MyBlockingQueue(int size) {
        capacity = size;
        items = new Object[size];
    }

//    synchronized
    public void enqueue(T t) throws InterruptedException {
        lock.lock();

        try {
            while (count == items.length)
//                Thread.currentThread().sleep(1);
                notFull.await();

            items[putIdx] = t;
            count++;
            putIdx = (putIdx + 1) % capacity;

            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }

    }

//    synchronized
    public T dequeue() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0)
//                Thread.currentThread().sleep(1);
                notEmpty.await();

            T t = (T)items[takeIdx];
            items[takeIdx] = null;
            takeIdx = ++takeIdx % capacity;
            count--;

            notFull.signalAll();
            return t;
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws Exception{

        MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        p.start();
        c.start();

        Map m1 = new HashMap();
        Map m2 = new Hashtable();

//        Thread.currentThread().sleep(3 * 1000);
    }
}
