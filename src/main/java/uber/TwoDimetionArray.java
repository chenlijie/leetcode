package uber;

public class TwoDimetionArray {

    static int findTarget(int[][] nums, int t) {
        int rot = findRotated(nums);

        int cols = nums[0].length;
        int lo = 0;
        int hi = nums.length * cols;
        int size = hi;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int realMi = (mi + rot) % size;

            int mi_x = realMi/cols;
            int mi_y = realMi%cols;

            if (nums[mi_x][mi_y] == t) {
//                if (t == nums[realMi/cols][realMi%cols])
                    System.out.println(realMi/cols + ", " + realMi%cols);
//                else
//                    System.out.println("-1, -1");
                return realMi;
            } else if (nums[mi_x][mi_y] > t) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        System.out.println("-1, -1");
        return lo;
    }

    static int findRotated(int[][] nums) {
        int cols = nums[0].length;
        int lo = 0;
        int hi = nums.length * cols - 1;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            int mi_x = mi/cols;
            int mi_y = mi%cols;

            int hi_x = hi/cols;
            int hi_y = hi%cols;

            if (nums[mi_x][mi_y] > nums[hi_x][hi_y]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {
                {3,4,5},
                {6,-2,-1},
                {0,1,2},
        };

        findTarget(nums, 11);
    }
}
