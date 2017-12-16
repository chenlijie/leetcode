package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/3/17.
 */
public class Missing_Ranges_161 {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();
        lower -= 1;

        for (int i = 0; i < nums.length; i++) {
            if (lower >= nums[i]) {
                continue;
            }
            addRange(result, lower+1, nums[i]-1);
            lower = nums[i];
        }

        addRange(result, lower+1, upper-1);
        return result;
    }

    private static void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add("" + start);
        } else if (start < end) {
            result.add(start + "->" + end);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMissingRanges(new int[]{0, 1, 2, 3, 50, 75}, -19, 100));
    }
}
