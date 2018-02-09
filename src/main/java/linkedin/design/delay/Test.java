package linkedin.design.delay;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {


    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) throws Exception {
        Condition c = lock.newCondition();

        new Thread(() -> {
            try {
//                Thread.sleep(1 * 1000);
                lock.lock();
                c.await(10, TimeUnit.SECONDS);
                System.out.println("1234");
//                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2500);
        lock.lock();
        c.await(4, TimeUnit.SECONDS);
        lock.unlock();

        System.out.println("ABC");
    }
}

