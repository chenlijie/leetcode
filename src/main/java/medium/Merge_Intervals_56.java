package medium;

import java.util.*;

public class Merge_Intervals_56 {

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        List<Interval> list = new ArrayList<Interval>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);

            if (list.size() == 0) {
                list.add(temp);
            } else {
                if (list.get(list.size()-1).end >= temp.start) {
                    if (list.get(list.size()-1).end < temp.end)
                        list.get(list.size()-1).end = temp.end;
                } else {
                    list.add(temp);
                }
            }
        }

        return list;
    }


    
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

    public static void main(String[] args) {
        Merge_Intervals_56.Interval a1 = new Merge_Intervals_56.Interval(1, 3);
        Merge_Intervals_56.Interval a2 = new Merge_Intervals_56.Interval(4, 9);
        Merge_Intervals_56.Interval a3 = new Merge_Intervals_56.Interval(5, 7);
        Merge_Intervals_56.Interval a4 = new Merge_Intervals_56.Interval(15, 18);
        List<Interval> intervals = new ArrayList<Interval>();

        intervals.add(a3);
        intervals.add(a4);
        intervals.add(a1);
        intervals.add(a2);

        for (Interval interval : new Merge_Intervals_56().merge(intervals)) {
            System.out.print(interval);
        }
    }
}