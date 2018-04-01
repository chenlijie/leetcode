package zillow;

public class CombinationSum {

    static int combinationSum(int[] nums, int sum) {
        return combinationSum(nums, 0, sum);
    }

    static int combinationSum(int[] nums, int start, int remain) {
        if (remain == 0)
            return 1;

        if (remain < 0)
            return 0;

        int total = 0;
        for (int i = start; i < nums.length; i++) {
            total += combinationSum(nums, i, remain - nums[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,6,7,1,4}, 8));
    }
}