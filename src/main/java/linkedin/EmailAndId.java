package linkedin;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenlijie on 12/12/17.
 */
public class EmailAndId {
    /*

    email - id
    one -> many

     */

    public static void main(String[] args) throws Exception {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTimeInMillis()/1000);
        c.add(Calendar.YEAR, 7000);
        System.out.println(c);
        System.out.println(c.getTime());
        System.out.println(c.getTimeInMillis());
        System.out.println(c.getTimeInMillis()/1000);
        System.out.println(Integer.MAX_VALUE/365/3600);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1517283389);
    }
}
