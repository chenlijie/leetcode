package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 9/2/17.
 */
public class Summary_Ranges_228 {

    public static List<String> summaryRanges(int[] nums) {

        List<String> summary = new ArrayList<>();

        int i = 0;
        int j = 1;
        while (j < nums.length) {
            int k = i;

            while (j < nums.length && nums[j] == nums[i]+1) {
                i++;
                j++;
            }

            if (i == k) {
                summary.add("" + nums[k]);
            } else {
                summary.add(nums[k] + "->" +nums[i]);
            }

            i = j;
            j += 1;
        }

        if (i < nums.length) {
            summary.add("" + nums[i]);
        }

        return summary;
    }

    public static void main(String[] args) {
        for (String s : summaryRanges(new int[]{0,1,2,3,4,5,6,7,8,9})) {
            System.out.print(s + "  ");
        }
    }
}
