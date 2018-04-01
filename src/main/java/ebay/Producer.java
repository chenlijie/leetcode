package ebay;

public class Producer extends Thread {

    private MyBlockingQueue<String> queue;
    private String name;
    private int i;

    public Producer(MyBlockingQueue<String> queue) {
        this.queue = queue;
        this.name = "producer";
        i = 0;
    }

    public Producer(MyBlockingQueue<String> queue, int i) {
        this.queue = queue;
        this.name = "producer";
        this.i = i;
    }

    public Producer(MyBlockingQueue<String> queue, String name, int i) {
        this.queue = queue;
        this.name = name;
        this.i = i;
    }

    @Override
    public void run() {

        while (true) {
            try {
                String s = name + (i++);
                System.out.println(Thread.currentThread().getName() + " puts " + s);
                queue.enqueue(s);
            } catch (InterruptedException e) {

            }
        }
    }
}
