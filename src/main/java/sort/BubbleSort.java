package sort;

/**
 * Created by chenlijie on 9/4/17.
 */
public class BubbleSort {

    public void sort(int[] nums) {

        int len = nums.length;
        for (int i = len-1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 5, 2, 3};
        new BubbleSort().sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
