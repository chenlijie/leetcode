package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/30/17.
 */
public class UnWeightShortestPath2 {

    //num is from [1, num]
    public void shortestPath(int[][] path, int num, int start) {

        int[] distance = new int[num+1];

        //-1: not visit, non-negative denotes distance from start vertex
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }

        //make start vertex as visited, the path to itself is 0
        distance[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            int from = queue.poll();

            for (int i = 0; i < path.length; i++) {
                int to = path[i][1];

                if (from == path[i][0] && distance[to] == -1) {
                    distance[to] = distance[from] + 1;

                    queue.offer(to);
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            System.out.println("The shortest path from " + start + " to " + i + " is " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int[][] path = new int[][] {
                {1, 2},
                {1, 4},
                {2, 4},
                {2, 5},
                {4, 3},
                {4, 7},
                {4, 6},
                {4, 5},
                {3, 1},
                {3, 6},
                {5, 7},
                {7, 6}
        };

        new UnWeightShortestPath2().shortestPath(path, 7, 1);
    }
}
