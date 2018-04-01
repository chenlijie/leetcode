package ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }

            while (i < len - 2 && nums[i] == nums[i + 1]) i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        threeSum(new int[] {-1,0,1,2,-1,-4});
    }
}
