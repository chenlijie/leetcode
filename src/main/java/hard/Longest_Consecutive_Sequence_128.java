package hard;

import java.util.*;

/**
 * Created by chenlijie on 12/31/17.
 */
public class Longest_Consecutive_Sequence_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int max = 1;
        int len = nums.length;

        for (int i = 1, j = 0; i < len; i++) {
            int dup = 0;
            while (i < len && (nums[i] == nums[i-1] + 1 || nums[i] == nums[i-1])) {
                if (nums[i] == nums[i-1]) {
                    dup++;
                }
                i++;
            }
            max = Math.max(max, i-j-dup);
            j = i;
        }

        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int n : nums) {
            if (!set.contains(n-1)) {
                int m = n + 1;
                while (set.contains(m)) {
                    m++;
                }
                max = Math.max(max, m-n);
            }
        }
        return max;
    }

    public int longestConsecutive3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i]-1, 0);
                int right = map.getOrDefault(nums[i]+1, 0);
                int total = left + right + 1;
                map.put(nums[i], left + right + 1);
                map.put(nums[i]-left, total);
                map.put(nums[i]+right, total);
                max = Math.max(max, total);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Longest_Consecutive_Sequence_128 c = new Longest_Consecutive_Sequence_128();
        int[] nums = new int[5000000];

        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(50000000);
        }

        long start = System.currentTimeMillis();
        c.longestConsecutive(nums);
        long end = System.currentTimeMillis();
        System.out.println("Sort : " + (end - start));

        start = System.currentTimeMillis();
        c.longestConsecutive2(nums);
        end = System.currentTimeMillis();
        System.out.println("HashSet : " + (end - start));

        start = System.currentTimeMillis();
        c.longestConsecutive3(nums);
        end = System.currentTimeMillis();
        System.out.println("HasMap : " + (end - start));
    }
}
