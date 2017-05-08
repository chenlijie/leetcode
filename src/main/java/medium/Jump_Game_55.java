package medium;

/**
 * Created by chenlijie on 5/6/17.
 */
public class Jump_Game_55 {


    public static boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;

        int s = 1;
        for (int i = nums.length-2; i >= 0; i--) {
             if (nums[i] >= s) {
                 s = 1;
             } else {
                 s++;
             }
        }

        if (nums[0] >= s) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{8,0,0,0,0,0,0,0,0,0}));
    }
}
