package pattern;


public class VolatileTest extends Thread{


     ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

//    int num = 0;

    public VolatileTest() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + num.get());
            num.set(num.get() + 1);
//            System.out.println(Thread.currentThread().getName() + " : " + (++num));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest t1 = new VolatileTest();
//        VolatileTest t2 = new VolatileTest();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        t1.start();

        char c = '1';
        c = (char)(c + 1);
        System.out.println(c);
    }
}
