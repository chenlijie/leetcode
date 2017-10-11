package hard;

import java.util.*;

/**
 * Created by chenlijie on 9/14/17.
 */
public class Count_of_Range_Sum_327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return 0;
        }

        int[] count = new int[1];
        countRangeSum(nums, 0, nums.length, lower, upper, count);
        return count[0];
    }
    
    private List<Long>[] countRangeSum(int[] nums, int lo, int hi, int lower, int upper, int[] count) {
        if (lo+1 == hi) {
            if (nums[lo] >= lower && nums[lo] <= upper) {
                count[0]++;
            }
            return new List[] {new ArrayList(0), Arrays.asList(nums[lo] + 0l), new ArrayList(0)};
        }

        int mi = lo + (hi - lo)/2;
        List<Long>[] left = countRangeSum(nums, lo, mi, lower, upper, count);
        List<Long>[] right = countRangeSum(nums, mi, hi, lower, upper, count);

        List<Long> firstPartOfLeft = left[0];
        long allOfLeft = left[1].get(0);
        List<Long> secondPartOfLeft = left[2];

        List<Long> firstPartOfRight = right[0];
        long allOfRight = right[1].get(0);
        List<Long> secondPartOfRight = right[2];

        for (int i = 0; i < secondPartOfLeft.size(); i++) {
            for (int j = 0; j < firstPartOfRight.size(); j++) {
                if (secondPartOfLeft.get(i) +  firstPartOfRight.get(j) >= lower
                        && secondPartOfLeft.get(i) +  firstPartOfRight.get(j) <= upper) {
                    count[0]++;
                }
            }
        }

        combine(firstPartOfLeft, firstPartOfRight, allOfLeft, lower, upper, count);
        combine(secondPartOfRight, secondPartOfLeft, allOfRight, lower, upper, count);

        long all = allOfLeft + allOfRight;
        if (all >= lower && all <= upper) {
            count[0]++;
        }

        return new List[] {firstPartOfLeft, Arrays.asList(all), secondPartOfRight};
    }

    private void combine(List<Long> left, List<Long> list, long add, int lower, int upper, int[] count) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            long val = list.get(i) + add;
            if (val >= lower && val <= upper) {
                count[0]++;
            }
            left.add(val);
        }



    }

    public static void main(String[] args) {
        System.out.println(new Count_of_Range_Sum_327().countRangeSum(new int[]{-3,1,2,-2,2,-1}, -3, -1));

        System.out.println(Integer.MAX_VALUE);
    }
}
