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

    static List<Integer> getNonDuplicate(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            res.add(nums[i]);

            while (i+1 < len && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getNonDuplicate(new int[]{2,1,3,2,3,3,4,0,1,0}));
        System.out.println(getNonDuplicate(new int[]{1,2,3,1,2,3,4,4,-1,-2,-3,-2}));
        System.out.println(new int[0]);
    }
}
