package microsoft.onsite;

public class TwoSmallestNumber {

    static void findSmallestNumbers(int[] nums) {

        int smallest = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[smallest]) {
                smallest = i;
            }
        }

        int secondSmallest = smallest == 0 ? 1 : 0;

        for (int i = secondSmallest + 1; i < nums.length; i++) {
            if (i != smallest && nums[i] < nums[secondSmallest]) {
                secondSmallest = i;
            }
        }

        System.out.println(nums[smallest] + ", " + nums[secondSmallest]);
    }

    static void findSmallestNumbers_2(int[] nums) {
        int first = 0;
        int second = 1;

        if (nums[second] < nums[first]) {
            first = 1;
            second = 0;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < nums[first]) {
                second = first;
                first = i;
            } else if (nums[i] < nums[second]) {
                second = i;
            }
        }

        System.out.println(nums[first] + ", " + nums[second]);
    }

    public static void main(String[] args) {
        findSmallestNumbers(new int[] {4, 3, 6, 1, 2, 5});
        findSmallestNumbers(new int[] {4, 3, 6, 1, 2, 5, 1, 9});

        findSmallestNumbers_2(new int[] {4, 3, 6, 1, 2, 5});
        findSmallestNumbers_2(new int[] {4, 3, 6, 1, 2, 5, 1, 9});
    }
}
