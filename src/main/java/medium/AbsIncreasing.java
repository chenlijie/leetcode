package medium;

import static medium.Sort_Colors_75.swap;
import static utility.Utils.printArray;

public class AbsIncreasing {

//    给⼀一个有正有负的递增数列列，返回⼀一个按绝对值⼤大⼩小排列列的数列列
//    分为正负两个部分做插⼊入，可以⽤用O(N)时间实现
//    如果是已经排好序的没必要找0吧，从两侧向中间⾛走就可以吧，两侧绝对值⼀一定最⼤

    static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        printArray(nums);
    }

    static void sort(int[] nums, int lo, int hi) {
        if (lo < hi) {

            int pivot = Math.abs(nums[hi]);
            int j = 0;

            for (int i = 0; i < hi; i++) {
                if (Math.abs(nums[i]) <= pivot) {
                    swap(nums, i, j);
                    j++;
                }
            }

            swap(nums, j, hi);

            sort(nums, lo, j-1);
            sort(nums, j+1, hi);
        }
    }

    public static void main(String[] args) {
        sort(new int[] {-5,-5, -2,1,1,3,6});
        sort(new int[0]);
    }
}
