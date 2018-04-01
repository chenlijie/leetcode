package microsoft;

import utility.Utils;

public class EvenOddNumber {

//    https://www.geeksforgeeks.org/even-numbers-even-index-odd-numbers-odd-index/

    static void sortByEvenAndOdd(int[] nums) throws Exception {

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] % 2 != i % 2) {
                if (j <= i) {
                    j = i + 1;
                }
                while (j < nums.length && i % 2 != nums[j] % 2)
                    j++;

                if (j == nums.length)
                    throw new Exception("invalid input");

                swap(nums, i, j);
            }
        }

        Utils.printArray(nums);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) throws Exception {
        sortByEvenAndOdd(new int[] {1,2,2,1,1,1,2,1,2,2,2,2,1,1,1,2});
//        sortByEvenAndOdd(new int[] {});
    }
}

