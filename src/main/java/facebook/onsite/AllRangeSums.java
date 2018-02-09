package facebook.onsite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllRangeSums {

//    1d array query一个range里面所有数字的和

    static List<Integer> allSums(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                ans.add(sum);
            }
        }
        Collections.sort(ans);
        System.out.println(ans);
        return ans;
    }

    static List<Integer> allSums2(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            ans.add(sum);
            for (int j = 0; j < i; j++) {
                ans.add(sum - nums[j]);
            }
        }
        Collections.sort(ans);
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        allSums(new int[] {1,2,3,4});
        allSums2(new int[] {1,2,3,4});
    }
}
