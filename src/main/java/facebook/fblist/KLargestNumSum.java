package facebook.fblist;

public class KLargestNumSum {

    static int largestSum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int[] bucket = new int[10];

        for (int n : nums) {
            bucket[n]++;
        }

        int sum = 0;
        int i = 9;
        while (k > 0 && i > 0) {
            if (bucket[i] == 0) {
                i--;
            } else {
                sum += i;
                bucket[i]--;
                k--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,4,9,3,8,9,6};

        System.out.println(largestSum(nums, 19));
    }
}
