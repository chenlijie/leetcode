package medium;

import java.util.Arrays;

/**
 * Created by chenlijie on 5/17/17.
 */
public class Longest_Increasing_Subsequence_300 {

    /**
     * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     */
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable   = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }

        return len;
    }



    public static int lengthOfLIS(int[] nums) {

        int[] m = new int[nums.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && m[j] >= m[i]) {
                    m[i] += 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m.length; i++) {
            max = Math.max(max, m[i]);
        }

        return max;
    }



    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{3, 2, 4, -1, 1, 2, 8, 3, 9, 5}));

        System.out.println(Arrays.binarySearch(new int[]{3, 5}, 0, 2, 4));
//        int A[] = { 2, 5, 3, 7, 11, 8, 10, 0, 13, 6 };
//        int n = A.length;
//        System.out.println("Length of Longest Increasing Subsequence is "+
//                LongestIncreasingSubsequenceLength(A, n));
    }
}
