package medium;

/**
 * Created by chenlijie on 5/11/17.
 */
public class Product_of_Array_Except_Self_238 {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    result[j] *= nums[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
}
