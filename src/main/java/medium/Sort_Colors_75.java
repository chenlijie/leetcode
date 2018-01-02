package medium;

/**
 * Created by chenlijie on 5/1/17.
 */
public class Sort_Colors_75 {

    // 0 0 0 0 1 1 2 2 2
    // 0 1 2 3 4 5 6 7 8
    public static void sortColors2(int[] nums) {

        int red = 0;
        int white = 0;

        for (int i : nums) {
            if (i == 0) red++;
            else if (i == 1) white++;
        }

        for (int i = red+white; i < nums.length; i++) {
            nums[i] = 2;
        }

        for (int i = red; i < red+white; i++) {
            nums[i] = 1;
        }

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int i = 0;

        while (i < r) {
            if (nums[i] == 2) {
                while (i < r && nums[i] == 2) {
                    swap(nums, i, r--);
                }
            } else if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
//        sortColors(new int[]{0,1,2,1,1,1,2,2,0,0,1,2,1,1,1});
        sortColors(new int[]{1, 0});
    }
}
