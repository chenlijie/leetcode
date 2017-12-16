package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 9/7/17.
 */
public class Contains_Duplicate_III_220 {

    private static long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0 || k < 1) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long n = (long)nums[i]-Integer.MIN_VALUE;
            long b = n/((long)t + 1);

            if (buckets.containsKey(b)
                    || buckets.containsKey(b-1) && n - buckets.get(b-1) <= t
                    || buckets.containsKey(b+1) && buckets.get(b+1) - n <= t) {
                return true;
            }

            if (buckets.size() >= k) {
                buckets.remove(((long)nums[i-k]-Integer.MIN_VALUE)/((long)t + 1));
            }

            buckets.put(b, n);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate2(new int[]{-1,2147483647}, 1, 2147483647));
    }
}
