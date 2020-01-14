package microsoft.onsite;

public class Singleton2 {

    private static Singleton2 singleton;

    private Singleton2() {
    }

    public static Singleton2 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton2.class) {

                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}
