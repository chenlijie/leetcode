package amazon.onsite;

public class MissingNumber {

    static void missingNumber(int[] nums) {
        if (nums.length == 0) {
            System.out.println(-1);
            return;
        }


        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (nums[mi] == mi) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

//        if (lo == nums.length)
//            System.out.println(-1);
//        else
            System.out.println(lo);
    }

    public static void main(String[] args) {
//        missingNumber(new int[0]);

        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i + 1;
        }

//        for (int i = 8; i < 10; i++) {
//            nums[i] = i + 1;
//        }
        missingNumber(nums);
    }
}
