package linkedin.design.delay;

import java.util.Calendar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {

    private int _expireInSecond = 0;
    int delay;

    public DelayedTask(int delaySecond) {
        delay = delaySecond;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, delaySecond);
        _expireInSecond = (int) (cal.getTimeInMillis() / 1000);
    }

    public int compareTo(Delayed o) {
        long d = (getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    public long getDelay(TimeUnit unit) {
        Calendar cal = Calendar.getInstance();
        return _expireInSecond - (cal.getTimeInMillis() / 1000);
    }

    @Override
    public String toString() {
        return "DelayedTask{" +
                "delay=" + delay +
                '}';
    }
}
