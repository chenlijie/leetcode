package facebook.fblist;

import utility.Utils;

public class UniqueNums {

    static int unique(int[] nums) {
        int len = nums.length;

        int i = 0, j = 0;

        while (i < len) {

            while (i + 1 < len && nums[i] == nums[i+1]) {
                i++;
            }

            swap(nums, j, i);
            j++;
            i++;
        }

        for (int k = 0; k < j; k++) {
            System.out.print(nums[k] + "  ");
        }
        System.out.println();
        return j;
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        unique(new int[] {1,1,1,2,2,3,3,4,4});
        unique(new int[] {1,2,3,4});
        unique(new int[0]);

    }
}
