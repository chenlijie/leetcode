package linkedin;

import java.util.*;

/**
 * Created by chenlijie on 12/12/17.
 */
public class NonDuplicate {

    static List<Integer> getNonDuplicate2(int[] nums) {
        Set<Integer> nonDup = new HashSet<>();
        Set<Integer> dup = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (dup.contains(nums[i])) {
                continue;
            }
            if (!dup.contains(nums[i]) && !nonDup.contains(nums[i])) {
                nonDup.add(nums[i]);
            } else if (!dup.contains(nums[i]) && nonDup.contains(nums[i])) {
                nonDup.remove(nums[i]);
                dup.add(nums[i]);
            }
        }

        return new ArrayList<>(nonDup);
    }

    // 1

    static List<Integer> getNonDuplicate(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        int j = 0;
        int i = 0;
        while (++i < len) {
            if (i < len && nums[j] == nums[i]) {
                continue;
            }

            if (i == j + 1) {
                res.add(nums[j]);
            }
            j = i;
        }

        if (i == j+1) {
            res.add(nums[j]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getNonDuplicate(new int[]{2,1,3,2,3,3,4,0,1,0}));
        System.out.println(getNonDuplicate(new int[]{1,2,3,1,2,3,4,4,-1,-2,-3,-2}));
        System.out.println(new int[0]);
    }
}
