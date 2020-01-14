package microsoft.onsite;

public class MediaOfSortedArray {

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        // if (nums1.length == 0 && nums2.length == 1)
        //     return nums2[0];

        int lo = 0;
        int hi = nums1.length;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;

        // even: i + j = len1 + len2 - i - j ===> j = len/2 - i
        // odd: i + j + 1 = len1 + len2 - i - j ===> j = (len-1)/2 - i;
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = len / 2 - i;

            if (i < len1 && nums1[i] < nums2[j - 1]) {
                lo = i + 1;
            } else if (i > 0 && nums2[j] < nums1[i - 1]) {
                hi = i;
            } else {
                int right;
                if (i == len1) {
                    right = nums2[j];
                } else if (j == len2) {
                    right = nums1[i];
                } else {
                    right = Math.min(nums1[i], nums2[j]);
                }

                if (len % 2 == 1) return right;

                int left;
                if (i == 0) {
                    left = nums2[j - 1];
                } else if (j == 0) {
                    left = nums1[i - 1];
                } else {
                    left = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                return (left + right) / 2.0;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[0], new int[] {2}));
    }
}
