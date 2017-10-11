package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 9/4/17.
 */
public class Find_Right_Interval_436 {

    public int[] findRightInterval(Interval[] intervals) {

        int[] nums = new int[intervals.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            nums[i] = intervals[i].start;
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        int[] output = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            output[i] = search(intervals[i].end, nums, map);
        }

        return output;
    }

    private int search(int t, int[] nums, Map<Integer, Integer> map) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = lo + (hi-lo)/2;

            if (t > nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo == nums.length ? -1 : map.get(nums[lo]);
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {

        int[] arr = new Find_Right_Interval_436().findRightInterval(new Interval[] {
//                new Interval(3,4),
//                new Interval(2,3),
//                new Interval(1,2)
                new Interval(1,2),
                new Interval(2,3),
                new Interval(0,1),
                new Interval(3,4),
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
