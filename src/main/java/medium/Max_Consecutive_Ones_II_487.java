package medium;

/**
 * Created by chenlijie on 9/10/17.
 */
public class Max_Consecutive_Ones_II_487 {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int zero = 0;
        int k = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
            }

            while (zero > k) {
                if (nums[left++] == 0) {
                    --zero;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0,1,1,0,1,1,0,0,0,1,1,1,0}));
    }
}
