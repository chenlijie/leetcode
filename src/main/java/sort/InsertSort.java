package sort;

/**
 * Created by chenlijie on 9/4/17.
 */
public class InsertSort {

    public void sort(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = i+1; j < len; j++) {

                int key = nums[j];
                int k = j;

                while (k > 0 && key < nums[k-1]) {
                    nums[k] = nums[k-1];
                    k--;
                }

                nums[k] = key;
            }
        }
    }

    public void sort2(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int key = nums[i];
            int j = i-1;

            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 5, 2, 3};
        new InsertSort().sort2(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
