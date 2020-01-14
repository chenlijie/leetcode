package amazon.design.traffic;

public class ControlSystem {
    Light[] lights;
    int curGreen;
    boolean isRunning = false;

    public ControlSystem() {
        lights = new Light[4];
        for (int i = 0; i < 4; i++) {
            lights[i] = new Light("Side " + i);
        }
        curGreen = 0;
        isRunning = true;
    }

    public void start(){

        new Thread() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        lights[curGreen].turnOn(Color.GREEN);
                        Thread.sleep(12 * 100);

                        lights[curGreen].turnOn(Color.YELLOW);
                        Thread.sleep(3 * 100);

                        lights[curGreen].turnOn(Color.RED);

                        int i = curGreen;
                        curGreen = (curGreen + 1) % 4;

                        System.out.println("Turn off : " + lights[i]);
                        System.out.println("Turn on : " + lights[curGreen]);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();

    }

    public void stop() {
        isRunning = false;
    }

    public static void main(String[] args) throws Exception {
        ControlSystem system = new ControlSystem();
        system.start();

        Thread.sleep(10 * 1000);
        system.stop();
    }
}
