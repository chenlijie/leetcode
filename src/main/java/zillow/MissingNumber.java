package zillow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=312423&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D31%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//    length为96的int array，数字范围从1-100，让你找4个missing numbers

    static void missingNumber(int[] nums, int range) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 1, j = 0; i <= range; i++) {
            if (j >= nums.length || i != nums[j]) {
                ans.add(i);
            } else {
                j++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[0] = 3;nums[1] = 5;nums[2] = 8;
        nums[3] = 4;nums[4] = 7;nums[5] = 9;

        missingNumber(nums, 12);

        "".split(".");
    }
}
