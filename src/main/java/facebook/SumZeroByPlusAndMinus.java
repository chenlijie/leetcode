package facebook;

public class SumZeroByPlusAndMinus {

    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=209154&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    static int sumToZero(int[] nums) {
        return helper(nums, 1, '+', nums[0], 0);
    }

    static int total = 0;

    static int helper(int[] nums, int i, char sign, int preNum, int preSum) {
        if (i == nums.length) {
            if (sign == '+') {
                preSum += preNum;
            } else {
                preSum -= preNum;
            }

            if (preSum == 0)
                total++;
            return preSum == 0 ? 1 : 0;
        }

        int cnt = 0;
        //add + or -
        if (sign == '+') {
            cnt += helper(nums, i + 1, '+', nums[i], preSum + preNum);
            cnt += helper(nums, i + 1, '-', nums[i], preSum + preNum);
        }

        if (sign == '-') {
            cnt += helper(nums, i + 1, '+', nums[i], preSum - preNum);
            cnt += helper(nums, i + 1, '-', nums[i], preSum - preNum);
        }

        if (preNum != 0 ) {
            cnt += helper(nums, i + 1, sign, 10 * preNum + nums[i], preSum);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(sumToZero(new int[] {2,0,2}));
        System.out.println(total);
    }
}
