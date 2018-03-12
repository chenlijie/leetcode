package pattern;

public class Singleton {

    /*
    private static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getSingleton() {
        return singleton;
    }
    */

    /*
    private static Singleton singleton;

    private Singleton() {}

    public static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
    */

    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1F", 16));
        Integer.toHexString(100);
    }
}
