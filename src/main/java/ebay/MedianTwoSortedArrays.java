package ebay;

public class MedianTwoSortedArrays {

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int m = nums1.length;
        int n = nums2.length;

        int lo = 0;
        int hi = m;

        //i + j = m + n - i - j + 1
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = (m + n + 1) / 2 - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                lo = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                hi = i - 1;
            } else {
                double maxLeft;
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1)
                return maxLeft;

                double minRight;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1, 1}, new int[]{1, 1}));
    }
}
