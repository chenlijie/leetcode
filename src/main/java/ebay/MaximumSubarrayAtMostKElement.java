package ebay;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSubarrayAtMostKElement {


    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=303975&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D16%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    static int maxSubArray(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        int[] subSums = new int[len];

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            subSums[i] = sum;
        }

        int max = Integer.MIN_VALUE;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (!q.isEmpty() && i - q.peekFirst() > k) {
                q.removeFirst();
            }

            if (i < k) {
                max = Math.max(max, subSums[i]);
            }
            if (!q.isEmpty()) {
                max = Math.max(max, subSums[i] - subSums[q.peekFirst()]);
            }

            while (!q.isEmpty() && subSums[i] <= subSums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        return max;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(maxSubArray(new int[] {2, -2, -2, 3, -3, 1}, 1));
        System.out.println(maxSubArray(new int[] {-4, -2, -1, -3}, 2));

        Integer a;
        Class c = Class.forName("java.lang.Integer");
        c.newInstance();

    }
}
