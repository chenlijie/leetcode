package medium;

import java.util.Arrays;

/**
 * Created by chenlijie on 12/10/17.
 */
public class Non_overlapping_Intervals_435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (i1,i2) -> i1.end == i2.end ? i2.start - i1.start : i1.end - i2.end);

        int cnt = 0;
        for (int j = 0, i = 1; i < intervals.length; i++) {
            if (overlap(intervals[j], intervals[i])) {
                cnt++;
            } else {
                j = i;
            }
        }
        return cnt;
    }

    boolean overlap(Interval i, Interval j) {
        return i.end > j.start;
    }

    public static void main(String[] args) {
        Non_overlapping_Intervals_435 non = new Non_overlapping_Intervals_435();
        System.out.println(non.eraseOverlapIntervals(new Interval[]{
                new Interval(-87,-39),
                new Interval(-85,-76),
                new Interval(-76,-10),
        }));
    }
}
