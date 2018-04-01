package zillow;

import utility.Utils;

public class RightShift {

    static void rightShift(int[] nums, int k) {
        if (nums.length == 0) return;

        int counter = 0;
        int idx = 0;
        int pre = nums[0];
        int len = nums.length;

        while (counter++ < len) {
            idx = (idx + k) % len;
            int valAtIdx = nums[idx];

            nums[idx] = pre;
            pre = valAtIdx;
        }

        Utils.printArray(nums);
    }

    public static void main(String[] args) {
        int[] arr = new int[0];// {1, 2, 3, 4, 5};
        rightShift_2(arr, 1);
        Utils.printArray(arr);
    }

    static void rightShift_2(int[] arr, int k) {
        int len = arr.length;
        reverse(arr, 0, len - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, len - 1);

    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

}
