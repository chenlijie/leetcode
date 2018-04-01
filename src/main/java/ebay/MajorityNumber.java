package ebay;

public class MajorityNumber {

    //Moore voting algorithm
    static int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
                count++;
            } else if (ans == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(ans);
        return ans;
    }

    static int majorityElement_2(int[] nums) {
        int[] counts = new int[32];

        for (int n : nums) {
            int x = 1;
            for (int i = 0; i < 32; i++) {
                counts[i] += x & n;
                n >>= 1;
            }
        }

        int m = nums.length / 2;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (counts[i] > m) {
                ans += 1 << i;
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        majorityElement(new int[] {6, 5, 5});

    }
}
