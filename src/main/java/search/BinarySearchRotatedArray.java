package search;

public class BinarySearchRotatedArray {

    static int getIdxOfMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mi = (lo + hi) >> 1;

            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    static int search(int[] nums, int t) {

        int rota = getIdxOfMin(nums);

        int len = nums.length;
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi)/2;
            int realMi = (mi + rota)%len;

            if (nums[realMi] == t) {
                return realMi;
            } else if (t > nums[realMi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo == len ? -1 : lo;
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[] {4,5,6,0,1}, 5) == 1);
//        System.out.println(search(new int[] {4,5,6}, 5) == 1);
//        System.out.println(search(new int[] {4,5,6,0,1,2,3}, 5) == 1);

        System.out.println(search(new int[] {14}, 5) == -1);
    }
}
