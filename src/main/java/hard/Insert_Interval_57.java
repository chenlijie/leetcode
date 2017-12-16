package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/13/17.
 */
public class Insert_Interval_57 {

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;

        List<Interval> ans = new ArrayList<>();

        int i = 0;
        int len = intervals.size();

        while (i < len && intervals.get(i).end < start) {
            ans.add(intervals.get(i++));
        }

        int j = i + 1;
        while (j < len && intervals.get(j).start < end) {
            j++;
        }

        newInterval.start = Math.min(start, intervals.get(i).start);
        newInterval.end = Math.max(end, intervals.get(j-1).end);
        ans.add(newInterval);

        while (j < len) {
            ans.add(intervals.get(j++));
        }

        return intervals;
    }

    public static void main(String[] args) {
        Interval i13 = new Interval(1, 3);
        Interval i69 = new Interval(6, 9);
        Interval i25 = new Interval(2, 5);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i13);
        intervals.add(i69);


        Insert_Interval_57 insert = new Insert_Interval_57();
        insert.insert(intervals, i25);
    }
}
