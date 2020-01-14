package microsoft.onsite;

import utility.Utils;

public class ResetArray {

//    给一个array，里面有偶数个int，然后把array重排成{ N1, N2, N3, …, N2k } →
//    { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

    static void reset(int[] nums) {
        int len = nums.length + 1;
        int moves = len / 2 - 1;
        int start = 1;
        int end = len / 2;

        while (moves > 0) {
            for (int i = start; i < end; i++) {
                swap(nums, i, i + moves);
            }
            moves--;
            start++;
        }

        Utils.printArray(nums);
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        reset(new int[] {1,2,3,4,5,6,7,8});
        reset(new int[] {1,2,3,4,5,6,7});
    }
}
