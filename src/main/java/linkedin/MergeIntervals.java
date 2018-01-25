package linkedin;

import medium.Interval;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

//    "实现一个class提供以下操作：
//     1. addInterval(int start, int end) - 加入一段interval
//     2. getTotalCoverage() - 返回总共能够cover的时间"

    List<Interval> intervals = new ArrayList<>();

    public List<Interval> insert(Interval newInterval) {
        int len = intervals.size();

        List<Interval> ans = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;

        int i = 0;
        while (i < len && start > intervals.get(i).end) {
            ans.add(intervals.get(i));
            i++;
        }

        while (i < len && end >= intervals.get(i).start) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }

        newInterval.start = start;
        newInterval.end = end;
        ans.add(newInterval);

        while (i < len) {
            ans.add(intervals.get(i++));
        }

        return ans;
    }
}
