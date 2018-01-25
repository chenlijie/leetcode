package linkedin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DelayedScheduler {

    static class Task {
        Thread job;
        long time;

        public Task(Runnable job, long time) {
            this.job = new Thread(job);
            this.time = time;
        }
    }
    Queue<Task> queue;
    boolean isRun;

    public DelayedScheduler() {
        this.queue = new LinkedList<>();//new ConcurrentLinkedQueue<>();
        this.isRun = false;
    }

    public void add(Runnable job, long time) {
        queue.add(new Task(job, time));
    }

    public void execute() {
        isRun = true;

        new Thread(() -> {
            while (isRun) {
                while (!queue.isEmpty()) {
                    Task t = queue.poll();
                    if (t.time <= System.currentTimeMillis()) {
                        t.job.start();
                    } else {
                        queue.add(t);
                    }
                }
            }
        }).start();
    }

    public void stop() {
        isRun = false;
    }

    public static void main(String[] args) {
        DelayedScheduler scheduler = new DelayedScheduler();
        scheduler.execute();


        for (int i = 0; i < 100; i++) {
            final int t = i;
            Runnable r = () -> System.out.println("hi" + t);
            scheduler.add(r, System.currentTimeMillis() + (i/100)*0);
        }

        while (true) {
            if (scheduler.queue.isEmpty()) {
                scheduler.stop();
                break;
            }
        }
    }
}
