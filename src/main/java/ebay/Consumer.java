package ebay;

public class Consumer extends Thread {

    private MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean stop = false;
        while (!stop) {
            try {
                String s = queue.dequeue();
                if (s == null) {
                    stop = true;
                    System.out.println("take null item : " + s);
                }
                System.out.println(Thread.currentThread().getName() + " take " + s);
            } catch (InterruptedException e) {

            }
        }
    }
}
