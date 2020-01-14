package amazon.onsite;

import java.time.Instant;
import java.time.temporal.TemporalField;
import java.util.Random;

public class RandomGenerate64Bits {

    static Random r = new Random();

    static long generate() {
        long num = 0;

        for (int i = 0; i < 64; i++) {
            int k = r.nextInt(2);
            if (k == 1)
                num += 1L<<i;
        }
        return num;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();

        for (int i = 0; i < 100000; i++) {
            System.out.println(generate());
//            System.out.println(r.nextLong());
        }

        System.out.println(start);
        System.out.println(Instant.now());
    }
}
