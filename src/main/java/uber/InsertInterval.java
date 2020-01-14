package uber;

import medium.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }

        if (newInterval != null)
            result.add(newInterval);
        return result;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(5,9));
        list.add(new Interval(12,14));
        list.add(new Interval(16,20));

        insert(list, new Interval(-10,-1));
    }
}
