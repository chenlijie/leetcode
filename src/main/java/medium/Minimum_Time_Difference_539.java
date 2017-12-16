package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chenlijie on 11/14/17.
 */
public class Minimum_Time_Difference_539 {

    static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);

        int len = timePoints.size();
        int min = convertToMins(timePoints.get(0)) + 24 * 60 - convertToMins(timePoints.get(len-1));

        for (int i = 1; i < len; i++) {
            min = Math.min(min, convertToMins(timePoints.get(i)) - convertToMins(timePoints.get(i-1)));
        }

        return min;
    }

    static int convertToMins(String time) {
        String[] s = time.split(":");
        return Integer.valueOf(s[0]) * 24 + Integer.valueOf(s[1]);
    }

    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59","00:00")));
    }
}
