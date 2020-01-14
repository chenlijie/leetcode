package amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestAscendingArray {
    
    static List<Integer> longestSubArray(int[] nums) {
        int[] len = new int[nums.length];
        int max = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len[i] = 1 + len[i - 1];
                max = Math.max(max, len[i]);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len.length; i++) {
           if (max == len[i])
               ans.add(i - max);
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        longestSubArray(new int[] {3,2,3,1,2,3});
        longestSubArray(new int[] {1,2,3,2,3,4,3,4,5});
    }
}
