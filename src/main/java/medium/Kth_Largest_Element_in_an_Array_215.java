package medium;

/**
 * Created by chenlijie on 5/18/17.
 */
public class Kth_Largest_Element_in_an_Array_215 {

    //quick select

    public static int findKthLargest(int[] nums, int k) {

        int[] x = new int[nums.length];

        for (int i = 0; i < x.length; i++) {
            x[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    x[j] += 1;
                } else {
                    x[i] += 1;
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] == k) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
