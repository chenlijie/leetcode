package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 9/11/17.
 */
public class Meeting_Rooms_II_253 {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * find the minimum number of conference rooms required.
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     * return 2.
     */

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

    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {return o1.start-o2.start;});

        List<Interval> list1 = new ArrayList<>();
        List<Interval> list2 = new ArrayList<>();

        int count = 0;
        int previous = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                previous = intervals[i].end;
            } else if (previous > intervals[i].start) {
                list1.add(intervals[i]);
            } else {
                previous = intervals[i].end;
            }
        }

        count++;

        while (!list1.isEmpty() || !list2.isEmpty()) {

            if (!list1.isEmpty()) {
                count++;
            }
            for (int i = 0; i < list1.size(); i++) {
                if (i == 0) {
                    previous = list1.get(i).end;
                } else if (previous > list1.get(i).start) {
                    list2.add(list1.get(i));
                } else {
                    previous = list1.get(i).end;
                }
            }
            list1 = new ArrayList<>();

            if (!list2.isEmpty()) {
                count++;
            }
            for (int i = 0; i < list2.size(); i++) {
                if (i == 0) {
                    previous = list2.get(i).end;
                } else if (previous > list2.get(i).start) {
                    list1.add(list2.get(i));
                } else {
                    previous = list2.get(i).end;
                }
            }
            list2 = new ArrayList<>();
        }

        return count;
    }
}
