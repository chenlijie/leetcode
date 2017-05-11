package easy;

/**
 * Created by chenlijie on 5/10/17.
 */
public class Rotate_Array_189 {

    //For example, with n = 7 and k = 3, the array
    // [1,2,3,4,5,6,7] is rotated to
    //  0 1 2 3 4 5 6
    // [5,6,7,1,2,3,4].
//    6 7 1 2 3 4 5
    // 3 4 5 6 7 1 2



    public void rotate(int[] nums, int k) {

        int len = nums.length;

        k = k%len;
        if (k < len/2) {
            int[] store = new int[k];
            for (int i = 0; i < k; i++) {
                store[i] = nums[len-k+i];
            }

            for (int i = len-k-1; i >= 0; i--) {
                nums[i+k] = nums[i];
            }

            for (int i = 0; i < k; i++) {
                nums[i] = store[i];
            }
        } else {
            k = len - k;
            int[] store = new int[k];
            for (int i = 0; i < k; i++) {
                store[i] = nums[i];
            }

            for (int i = k; i < len; i++) {
                nums[i-k] = nums[i];
            }

            for (int i = 0; i < k; i++) {
                nums[len-k+i] = store[i];
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Rotate_Array_189().rotate(nums, 5);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }
}
