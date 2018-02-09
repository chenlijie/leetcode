package airbnb;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Contains_Duplicate_III_220 {

    static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0 || k < 1) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long reMapNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = reMapNum / ((long)t+1);

            if (buckets.containsKey(bucket)) return true;
            if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - reMapNum <= t) return true;
            if (buckets.containsKey(bucket - 1) && reMapNum - buckets.get(bucket - 1) <= t) return true;

            buckets.put(bucket, reMapNum);

            if (i >= k) {
                bucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                buckets.remove(bucket);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[] {-1, 2147483647}, 1, 2147483647));
    }
}
