package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Binary_Watch_401 {

    public List<String> readBinaryWatch(int num) {
        if (num == 0) {
            return new ArrayList<>();
        }

        int[] time = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        List<String> list = new ArrayList<>();
        backTracking(time, 0, 0, 0, list, num);

        return list;
    }

    private void backTracking(int[] time, int index, int hour, int minute, List<String> list, int num) {
        if (hour >= 12 || minute >= 60) {
            return;
        }
        if (num == 0) {
            list.add(hour + ":" + (minute < 10 ? "0"+minute : minute));
            return;
        }

        for (int i = index; i < time.length; i++) {
            if (i <= 3) {
                backTracking(time, i+1, hour+time[i], minute, list, num-1);
            } else {
                backTracking(time, i+1, hour, minute+time[i], list, num-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Binary_Watch_401().readBinaryWatch(2));
    }
}
