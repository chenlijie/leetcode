package uber;

public class RotatedArray {

    static int search(int[] nums, int target) {
        int rot = findRotated(nums);

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int realMi = (mi + rot) % nums.length;

            if (nums[realMi] == target) {
                return realMi;
            } else if (nums[realMi] > target) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return -1;
    }

    static int findRotated(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        System.out.println(lo);
        return lo;
    }

    public static void main(String[] args) {
//        findRotated(new int[] {1});
//        findRotated(new int[] {1,2});
//        findRotated(new int[] {1,2,3});
//        findRotated(new int[] {4,1,2,3});
//        findRotated(new int[] {4,5,1,2,3});
        search(new int[] {2,3,4,5,-2,-1,1}, -11);
    }
}
