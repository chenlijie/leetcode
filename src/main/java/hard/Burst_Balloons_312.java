package hard;

/**
 * Created by chenlijie on 9/17/17.
 */
public class Burst_Balloons_312 {

    public static int maxCoins(int[] nums) {

        int idx = 0;
        int total = 0;
        int len = nums.length;
        boolean find = true;

        while (find) {

            find = false;
            int maxWeight = 0;
            int i = 0;
            for (; i < len; i++) {
                if (nums[i] == -1 || nums[i] == 0) {
                    nums[i] = -1;
                    continue;
                }

                int j = i - 1;
                while (j >= 0 && nums[j] == -1) {
                    j--;
                }

                int k = i + 1;
                while (k < len && nums[k] == -1) {
                    k++;
                }

                int weight;

                if (j == -1 && k == len) {
                    weight = nums[i];
                } else if (j == -1) {
                    weight = nums[i] * nums[k];
                } else if (k == len) {
                    weight = nums[j] * nums[i];
                } else {
                    weight = nums[j] * nums[i] * nums[k];
                }

                if (maxWeight == 0
                        || weight * nums[idx] > maxWeight * nums[i]
                        || (weight * nums[idx] == maxWeight * nums[i] && weight > maxWeight)) {
                    idx = i;
                    maxWeight = weight;
                    find = true;
                }
            }

            if (find) {
                nums[idx] = -1;
                total += maxWeight;
            }
        }
        return total;
    }

    public static void main(String[] args) {
//        System.out.println(maxCoins(new int[]{0,3,1,5,8}));

        System.out.println(maxCoins(new int[]{9,76,64,21,97,60,5}));
    }
}
