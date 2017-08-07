package medium;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Total_Hamming_Distance_477 {

    public int totalHammingDistance(int[] nums) {

        int[] t = new int[32];
        int len = nums.length;

        for (int i = 0; i < 32; i++) {

            for (int j = 0; j < len; j++) {
                t[i] += nums[j] & 1;
                nums[j] >>= 1;
            }
        }

        int distance = 0;
        for (int i = 0; i < 32; i++) {
            distance += (len-t[i])*t[i];
        }

        return distance;
    }

    public static void main(String[] args) {
        System.out.println(new Total_Hamming_Distance_477().totalHammingDistance(new int[]{4, 14, 2}));
    }
}
