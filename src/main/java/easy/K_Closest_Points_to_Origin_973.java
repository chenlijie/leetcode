package easy;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class K_Closest_Points_to_Origin_973 {

    public static int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> {
            double d1 = Math.pow(p1[0], 2) + Math.pow(p1[1], 2);
            double d2 = Math.pow(p2[0], 2) + Math.pow(p2[1], 2);

            if (d1 < d2)
                return 1;
            else if (d1 > d2)
                return -1;
            else
                return 0;
        });

        for (int[] p : points) {
            queue.offer(p);

            if (queue.size() > K)
                queue.poll();
        }

        int[][] ans = new int[queue.size() < K ? queue.size() : K][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }

        for (int[] p : ans) {
            System.out.println(p[0] + ", " + p[1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
                {3,3},
                {5,-1},
                {-2,4},
        };

        kClosest(points, 2);

    }
}
