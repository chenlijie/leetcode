package amazon_onsite;

import utility.Utils;

/**
 * Created by chenlijie on 12/5/17.
 */
public class ClosetTotalSum {
    //sequence of numbers, equal size,
    // how to re allocate to make two new sequence of equal size
    // with closest total number sum

    void closetTotalSum(int[] a1, int[] a2) {
        int len = a1.length;
        int[] nums = merge(a1, a2);

        int s1 = 0;
        int s2 = 0;

        int i1 = len - 1;
        int i2 = len - 1;

        int j = 2*len - 1;

        while (j >= 0 && i1 >= 0 && i2 >= 0) {
            if (s1 < s2) {
                a1[i1] = nums[j];
                s1 += a1[i1];
                i1--;
            } else {
                a2[i2] = nums[j];
                s2 += a2[i2];
                i2--;
            }
            j--;
        }

        while (i1 >= 0) {
            a1[i1] = nums[j--];
            s1 += a1[i1];
            i1--;
        }
        while (i2 >= 0) {
            a2[i2] = nums[j--];
            s2 += a2[i2];
            i2--;
        }

        Utils.printArray(a1);
        System.out.println("s1 = " + s1);
        Utils.printArray(a2);
        System.out.println("s2 = " + s2);
    }

    int[] merge(int[] a1, int[] a2) {
        int len = a1.length;
        int[] nums = new int[2*len];

        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < len && i2 < len) {
            if (a1[i1] < a2[i2]) {
                nums[j++] = a1[i1++];
            } else {
                nums[j++] = a2[i2++];
            }
        }

        while (i1 < len) {
            nums[j++] = a1[i1++];
        }

        while (i2 < len) {
            nums[j++] = a2[i2++];
        }

        int sum = 0;
        for (int n : nums)
            sum += n;

        System.out.println("avg: " + (sum/(2)));

        return nums;
    }

    public static void main(String[] args) {
        int[] a1 = new int[] {7, 500, 501};
        int[] a2 = new int[] {8, 9, 1000};

        ClosetTotalSum sum = new ClosetTotalSum();
        sum.closetTotalSum(a1, a2);
    }
}
