package linkedin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorServiceTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = () -> {
            System.out.println("a");
        };
//        service.submit(r);
        service.execute(r);

    }
}
