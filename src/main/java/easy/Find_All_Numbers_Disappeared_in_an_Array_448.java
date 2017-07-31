package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Find_All_Numbers_Disappeared_in_an_Array_448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int[] t = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            t[nums[i]]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < t.length; i++) {
            if (t[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }

        return list;
    }

    //1 - 6
    //4,4,3,3,2,1
    //4,4,-3,-3,2,1


    public static void main(String[] args) {
        int[] t = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers2(t));
    }
}
