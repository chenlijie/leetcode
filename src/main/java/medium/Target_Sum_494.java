package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/19/17.
 */
public class Target_Sum_494 {

    public static int findTargetSumWays(int[] nums, int S) {

        int count = 0;

        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sum);

        for (int i = 0; i < nums.length; i++) {

            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int pre = queue.poll();

                queue.offer(pre + nums[i]);
                queue.offer(pre - nums[i]);
            }

        }

        while (queue.size() != 0) {

            if (queue.poll() == S) {
                count++;
            }
        }

        return count;
    }

//    [27,22,39,22,40,32,44,45,46,8,8,21,27,8,11,29,16,15,41,0]
//            10
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{27,22,39,22,40,32,44,45,46,8,8,21,27,8,11,29,16,15,41,0}, 10));
    }
}
