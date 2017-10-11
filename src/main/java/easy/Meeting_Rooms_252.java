package easy;

import medium.Merge_Intervals_56;

import java.util.Arrays;

/**
 * Created by chenlijie on 9/11/17.
 */
public class Meeting_Rooms_252 {

    static public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {return o1.start-o2.start;});

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }

        return true;
    }
}
