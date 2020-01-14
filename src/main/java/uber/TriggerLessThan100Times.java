package uber;


import java.util.Random;

public class TriggerLessThan100Times {

//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=390330&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    static long lastCheck = System.currentTimeMillis();
    static int allows = 0;

    static void func() {
        System.out.println("func");
    }

    static void trigger() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastCheck;
        lastCheck = now;

        if (elapsed < 1000) {
            allows++;
        } else {
            allows = 1;
        }

        System.out.println(allows);
    }

    static void times() {
        if (allows < 100) {
            func();
        } else {
            allows = 100;
        }
    }

    public static void main(String[] args) throws Exception {

        new Thread() {

            @Override
            public void run() {
                while (true)
                    times();
            }
        }.start();

        while (true) {
            Thread.sleep(new Random().nextInt(16));
            trigger();
        }
    }
}
