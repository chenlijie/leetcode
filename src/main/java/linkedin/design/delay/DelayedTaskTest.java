package linkedin.design.delay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

public class DelayedTaskTest {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //定义延迟队列
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<DelayedTask>();

        //定义三个延迟任务
        DelayedTask task1 = new DelayedTask(10);
        DelayedTask task2 = new DelayedTask(5);
        DelayedTask task3 = new DelayedTask(15);

        new Thread(() -> {

            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                try {



                    DelayedTask t1 = new DelayedTask(new Random().nextInt(6));
                    delayQueue.add(t1);

//                Thread.sleep(1 * 1000);
//                DelayedTask t2 = new DelayedTask(1);
//                delayQueue.add(t2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();


        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " starts");
                    DelayedTask t = delayQueue.take();
                    System.out.println(Thread.currentThread().getName() + " " + t.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " starts");
                    DelayedTask t = delayQueue.take();
                    System.out.println(Thread.currentThread().getName() + " " + t.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " starts");
                    DelayedTask t = delayQueue.take();
                    System.out.println(Thread.currentThread().getName() + " " + t.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                delayQueue.add(new DelayedTask(10));
//            }
//        }.start();

//        new Thread(() -> {
//            try {
//                DelayedTask task = delayQueue.take();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//
//        new Thread(() -> {
//            try {
//                Thread.sleep(4*1000);
//                DelayedTask task = delayQueue.take();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

//        DelayedTask t = delayQueue.take();
//        System.out.println(Thread.currentThread().getName() + " " + t.toString());


        Thread.sleep(1000 * 100000);
//        delayQueue.add(task2);
//        delayQueue.add(task3);




//        while (delayQueue.size() != 0) {

            //如果没到时间，该方法会返回
//            DelayedTask task = delayQueue.take();//.poll();

//            if (task != null) {
//                Date now = new Date();
//                System.out.println(sdf.format(now));
//            }

//            Thread.sleep(1000);
//        }
    }
}
