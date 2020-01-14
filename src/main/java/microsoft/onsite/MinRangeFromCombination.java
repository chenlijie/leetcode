package microsoft.onsite;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinRangeFromCombination {

    private static class Data {
        int idx = 0;
        int[] array;

        public Data(int[] array) {
            this.array = array;
        }

        int get() {
            return array[idx];
        }
    }

    static int minRange(int[][] grid) {
        int maxNum = grid[0][0];
        Queue<Data> q = new PriorityQueue<>((d1, d2) -> d1.get() - d2.get());

        for (int i = 0; i < grid.length; i++) {
            maxNum = Math.max(maxNum, grid[i][0]);
            q.offer(new Data(grid[i]));
        }

        int min = Integer.MAX_VALUE;

        while (q.size() == grid.length) {
            Data d = q.poll();

            min = Math.min(min, maxNum - d.get());

            if (++d.idx < d.array.length) {
                q.offer(d);
                maxNum = Math.max(maxNum, d.get());
            }
        }

        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 17, 19},
                {5, 18, 25},
                {9, 17, 22}
        };

        minRange(grid);
    }
}
