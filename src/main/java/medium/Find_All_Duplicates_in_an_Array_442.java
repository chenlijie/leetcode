package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Find_All_Duplicates_in_an_Array_442 {

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            }

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] t = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(t));
    }
}
