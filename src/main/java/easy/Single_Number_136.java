package easy;

public class Single_Number_136 {

    public static int singleNumber(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[0] ^= nums[i];
        }

        return nums[0];
    }
}
