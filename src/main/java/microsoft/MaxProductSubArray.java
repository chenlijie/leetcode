package microsoft;

public class MaxProductSubArray {

    static int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int max = maxHere;
        int maxLoc = 0;
        int len = nums.length;
        int[] minStarts = new int[len];
        int[] maxStarts = new int[len];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                if (nums[i] > nums[i] * maxHere) {
                    maxHere = nums[i];
                    maxStarts[i] = i;
                } else {
                    maxHere = nums[i] * maxHere;
                    maxStarts[i] = maxStarts[i - 1];
                }

                if (nums[i] < nums[i] * minHere) {
                    minHere = nums[i];
                    minStarts[i] = i;
                } else {
                    minHere = nums[i] * minHere;
                    minStarts[i] = minStarts[i - 1];
                }
//                maxHere = Math.max(nums[i], nums[i] * maxHere);
//                minHere = Math.min(nums[i], nums[i] * minHere);
            } else {
                int t = maxHere;
                if (nums[i] > nums[i] * minHere) {
                    maxHere = nums[i];
                    maxStarts[i] = i;
                } else {
                    maxHere = nums[i] * minHere;
                    maxStarts[i] = minStarts[i - 1];
                }

                if (nums[i] < nums[i] * t) {
                    minHere = nums[i];
                    minStarts[i] = i;
                } else {
                    minHere = nums[i] * t;
                    minStarts[i] = maxStarts[i - 1];
                }
//                maxHere = Math.max(nums[i], nums[i] * minHere);
//                minHere = Math.min(nums[i], nums[i] * t);
            }

            if (maxHere > max) {
                max = maxHere;
                maxLoc = i;
            }
//            max = Math.max(max, maxHere);
        }

        int product = 1;
        for (int i = maxStarts[maxLoc]; i <= maxLoc; i++) {
            product *= nums[i];
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        System.out.println(product == max);

        return max;
    }

    public static void main(String[] args) {
        maxProduct(new int[] {-4, 5, -2, -1, 8});
    }
}
