package medium;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Find_Peak_Element_162 {

    public static int findPeakElement(int[] nums) {

        int[] t = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                t[i] = t[i-1] + 1;
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i] > max) {
                index = i;
                max = t[i];
            }
        }

        return index;
    }

    public static int findPeakElement2(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }

        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }

    public static void main(String[] args) {
        System.out.println(8>>>1);
        System.out.println(findPeakElement2(new int[]{1,2,10,2,3,2,3}));
    }
}
