package amazon.onsite;

public class SingleDigit {

//    single digit follow up 如果输入排好序，如何优化，应该也是lc的一道原题

    static int single(int[] nums) {

        int len = nums.length;
        int lo = 0;
        int hi = len;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (mi % 2 == 1) {
                if (nums[mi] == nums[mi - 1]) {
                    lo = mi + 1;
                } else {
                    hi = mi;
                }
            } else {
                if (mi + 1 < hi) {
                    if (nums[mi] == nums[mi + 1]) {
                        lo = mi + 2;
                    } else {
                        hi = mi;
                    }
                } else {
                    return nums[mi];
                }
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(single(new int[] {1}));
        System.out.println(single(new int[] {1,2,2,3,3,4,4,5,5,6,6}));
        System.out.println(single(new int[] {1,1,2,2,3,3,4,4,5,5,6,6,7}));
    }
}
