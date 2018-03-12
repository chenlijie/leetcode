package morgen;

public class DemoThread extends Thread {

    int x = 2;

    public DemoThread() {
        System.out.println("test");
        x = 5;
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run");
        System.out.println(Thread.currentThread().getName());
        x *= 2;
        System.out.println(x);
    }

    public void method() throws Exception {
        System.out.println(Thread.currentThread().getName());
        join();
        x = x - 1;
        System.out.println(x);
    }

    public static void main(String[] args) throws Exception {
        new DemoThread().method();
    }
}
