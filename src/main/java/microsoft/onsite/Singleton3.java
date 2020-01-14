package microsoft.onsite;

public class Singleton3 {

    private static Singleton3 singleton;

    private Singleton3() {
    }

    public static synchronized Singleton3 getSingleton() {

        if (singleton == null)
            singleton = new Singleton3();
        return singleton;
    }
}
