package facebook;

import medium.Interval;

import java.util.ArrayList;
import java.util.List;

public class IntersectionIntervals {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=307487&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3089%255D%255Bvalue%255D%255B2%255D%3D2%26searchoption%255B3089%255D%255Btype%255D%3Dcheckbox%26searchoption%255B3046%255D%255Bvalue%255D%3D2%26searchoption%255B3046%255D%255Btype%255D%3Dradio&page=1
    //Time complexity O(m+n)
    static List<Interval> insersection(List<Interval> intervals1, List<Interval> intervals2) {
        if (intervals1 == null || intervals1.isEmpty() || intervals2 == null || intervals2.isEmpty())
            return new ArrayList<>();

        int size1 = intervals1.size();
        int size2 = intervals2.size();

        int i1 = 0;
        int i2 = 0;

        List<Interval> ans = new ArrayList<>();

        while (i1 < size1 && i2 < size2) {
            Interval inter2 = intervals2.get(i2);

            while (i1 < size1 && inter2.start > intervals1.get(i1).end) {
                i1++;
            }

            if (i1 < size1) {
                int start = Math.max(inter2.start, intervals1.get(i1).start);
                int end = Math.min(inter2.end, intervals1.get(i1).end);

                if (start <= end) {
                    ans.add(new Interval(start, end));
                }
            }

            int t = i1;
            while (i1 < size1 && inter2.end >= intervals1.get(i1).start) {
                i1++;
            }

            if (i1 -1 > t) {
                int start = Math.max(inter2.start, intervals1.get(i1-1).start);
                int end = Math.min(inter2.end, intervals1.get(i1-1).end);

                if (start <= end) {
                    ans.add(new Interval(start, end));
                }
            }

            i1--;
            i2++;
        }

        return ans;
    }

    static List<Interval> intersection(List<Interval> intervals1, List<Interval> intervals2) {
        if (intervals1 == null || intervals1.isEmpty() || intervals2 == null || intervals2.isEmpty())
            return new ArrayList<>();

        List<Interval> ans = new ArrayList<>();
        int m = intervals1.size();
        int n = intervals2.size();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            int start = Math.max(intervals1.get(i).start, intervals2.get(j).start);
            int end = Math.min(intervals1.get(i).end, intervals2.get(j).end);

            if (start <= end) {
                ans.add(new Interval(start, end));
            }

            if (intervals1.get(i).end < intervals2.get(j).end) {
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }

    //Time complexity O(m*logn)
    static List<Interval> intersectionByBinarySearch(List<Interval> intervals1, List<Interval> intervals2) {
        if (intervals1 == null || intervals1.isEmpty() || intervals2 == null || intervals2.isEmpty())
            return new ArrayList<>();

        int n = intervals2.size();
        List<Interval> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int startIdx = findStartIdx(intervals2.get(i).start, intervals1);
            int endIdx = findEndIdx(intervals2.get(i).end, intervals1);

            for (int j = startIdx; j < endIdx; j++) {
                int start = Math.max(intervals1.get(j).start, intervals2.get(i).start);
                int end = Math.min(intervals1.get(j).end, intervals2.get(i).end);
                ans.add(new Interval(start, end));
            }
        }

        return ans;
    }

    static int findStartIdx(int start, List<Interval> intervals) {
        int lo = 0;
        int hi = intervals.size();

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (start > intervals.get(mi).end) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    static int findEndIdx(int end, List<Interval> intervals) {
        int lo = 0;
        int hi = intervals.size();

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (end > intervals.get(mi).start) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

}
