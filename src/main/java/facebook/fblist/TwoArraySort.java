package facebook.fblist;

import utility.Utils;

public class TwoArraySort {

//    输⼊入两个array {3,2,4,1,5,0} {D,C,E, B,F,A} 程序结束后得到 {0,1,2,3,4,5} {A,B,C,D,E,F}

    void sort(int[] nums, char[] letters) {

        if (nums == null || nums.length == 0 || letters == null || letters.length == 0 || nums.length != letters.length)
            return;

        int len = nums.length;
        int i = 0;

        while (i < len) {
            if (i != nums[i]) {
                swap(nums, letters, i, nums[i]);
            } else {
                i++;
            }
        }

        Utils.printArray(nums);
        Utils.printArray(letters);
    }

    void swap(int[] nums, char[] letters, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

        char c = letters[i];
        letters[i] = letters[j];
        letters[j] = c;
    }

    public static void main(String[] args) {
        new TwoArraySort().sort(new int[] {3,2,4,1,5,0}, new char[] {'D','C','E','B','F','A'});
    }
}
