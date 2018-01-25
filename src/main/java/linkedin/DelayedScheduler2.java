package linkedin;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DelayedScheduler2 {

    static class Task {
        Thread job;
        long time;

        public Task(Runnable job, long time, int id) {
            this.job = new Thread(job, id+"");
            this.time = time;
        }
    }
    PriorityQueue<Task> queue;
    boolean isRun;

    public DelayedScheduler2() {
        this.queue = new PriorityQueue<>((o1,o2) -> (int)(o1.time - o2.time));
        this.isRun = false;
    }

    public void add(Runnable job, long time, int id) {
        queue.add(new Task(job, time, id));
    }

    public void execute() {
        isRun = true;

        new Thread(() -> {
            while (isRun) {
                if (!queue.isEmpty() && queue.peek().time <= System.currentTimeMillis()) {
                    Thread t = queue.poll().job;
                    System.out.println(t.getName());
                    t.start();
                }
            }
        }).start();
    }

    public void stop() {
        isRun = false;
    }

    public static void main(String[] args) {
        DelayedScheduler2 scheduler = new DelayedScheduler2();
        scheduler.execute();

        for (int i = 0; i < 100; i++) {
            final int t = i;
            Runnable r = () -> System.out.println("hi" + t);
            scheduler.add(r, System.currentTimeMillis() + 1, i);
        }

        while (!scheduler.queue.isEmpty()) {
            if (scheduler.queue.isEmpty()) {
                scheduler.stop();
                System.out.println(Thread.currentThread().getName());
                break;
            }
        }
    }
}
