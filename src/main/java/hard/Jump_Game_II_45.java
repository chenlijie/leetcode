package hard;

/**
 * Created by chenlijie on 12/29/17.
 */
public class Jump_Game_II_45 {

    static int jump(int[] nums) {

        int len = nums.length;
        int[] steps = new int[len];

        for (int i = 0; i < len; i++) {
            steps[i] = i;
        }

        for (int i = 0; i < len; i++) {

            int farthest = Math.min(len-1, nums[i] + i);

            if (farthest == len-1) {
                steps[len-1] = steps[i] + 1;
                break;
            }

            for (int j = i+1; j <= farthest; j++) {
                steps[j] = Math.min(steps[i] + 1, steps[j]);
            }
        }
        return nums[len-1];
    }

    public static void main(String[] args) {
        jump(new int[]{1, 2});
    }
}
