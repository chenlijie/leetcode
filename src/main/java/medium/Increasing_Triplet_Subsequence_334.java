package medium;

/**
 * Created by chenlijie on 5/17/17.
 */
public class Increasing_Triplet_Subsequence_334 {

    public static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int[] triplet = new int[3];
        triplet[0] = nums[0];

        int min = nums[0];
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                count++;
                if (count == 2) {
                    return true;
                } else {
                    min = nums[i];
                    triplet[count] = nums[i];
                }
            } else {
                if (count > 0 && nums[i] > triplet[count-1]) {
                    min = nums[i];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{5,4,6,3,2,1,2,2,3}));
        System.out.println(increasingTriplet(new int[]{5,4,6,3,2,1,2,2,8}));
        System.out.println(increasingTriplet(new int[]{5,4,6,3,2,1,2}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet(new int[]{1,3,2,4}));
        System.out.println(increasingTriplet(new int[]{1,2,4}));
        System.out.println(increasingTriplet(new int[]{2,4}));
    }
}
