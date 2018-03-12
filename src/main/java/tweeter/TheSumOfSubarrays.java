package tweeter;

public class TheSumOfSubarrays {

    static int sum(int[] nums) {
        int[] s = new int[nums.length + 1];

        int total = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            s[i+1] = sum;

            for (int j = i; j >= 0; j--) {
                total += sum - s[j];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[] {1,2,3,4}));
    }
}
