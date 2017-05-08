package hard;

/**
 * Created by chenlijie on 5/5/17.
 */
public class First_Missing_Positive_41 {

    public static int firstMissingPositive(int[] nums) {

        int[] array = new int[nums.length];
        int i;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < nums.length) {
                array[nums[i]] = nums[i];
            }
        }

        for (i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }

        return i;
    }


    public static int firstMissingPositive2(int[] nums) {

        int i;

        for (i = 0; i < nums.length; ) {
            if (nums[i] >= 0 && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        int k = 1;
        while (k < nums.length && nums[k] == k)
            k++;

        if (nums.length == 0 || k < nums.length)
            return k;
        else
            return nums[0] == k ? k + 1 : k;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive2(new int[]{2,1}) == 3);
        System.out.println(firstMissingPositive2(new int[]{1,1}) == 2);
        System.out.println(firstMissingPositive2(new int[]{1}) == 2);
        System.out.println(firstMissingPositive2(new int[]{1,2,0}) == 3);
        System.out.println(firstMissingPositive2(new int[]{9,10,0}) == 1);
        System.out.println(firstMissingPositive2(new int[]{3,4,0,-1,1}) == 2);
    }

}
