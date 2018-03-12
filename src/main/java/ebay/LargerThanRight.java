package ebay;

import java.util.ArrayList;
import java.util.List;

public class LargerThanRight {

//    打印出一个数组里element右边所有值都比他小的所有element


    static List<Integer> solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        solution(new int[] {4, 19, 8, 13, 6, 9, 5, 2, 3, 1});
    }
}
