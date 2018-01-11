package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 8/30/17.
 */
public class DijkstraShortestPath {

    public void shortestPath(int[][] path, int num, int start) {

        int[][] state = new int[num+1][3];

        // first dimension : 1 - visited, 0 - not visit
        // second dimension : distance
        // third dimension : from which vertex
        for (int i = 1; i <= num; i++) {
            state[i][0] = 0;
            state[i][1] = Integer.MAX_VALUE;
            state[i][2] = 0;
        }

        //update start vertex
        state[start][0] = 1;
        state[start][1] = 0;
        state[start][2] = start;

        List<Integer> queue = new ArrayList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            //find current shortest path
            int index = 0;
            int min = queue.get(0);
            int minPath = state[min][1];
            for (int i = 1; i < queue.size(); i++) {
                if (minPath < state[queue.get(i)][1]) {
                    index = i;
                    min = queue.get(i);
                    minPath = state[min][1];
                }
            }

            queue.remove(index);

            int from = min;
            int currDis = minPath;
            for (int i = 0; i < path.length; i++) {
                int to = path[i][1];
                int distance = path[i][2];

                if (from == path[i][0] && state[to][0] == 0 && (distance+currDis) < state[to][1]) {
                    state[to][1] = distance+currDis;
                    state[to][2] = from;

                    queue.add(to);
                }
            }
        }

        for (int i = 1; i < state.length; i++) {
            System.out.println("The shortest path from " + start + " to " + i + " is " + state[i][1]);
        }
    }

    public static void main(String[] args) {
        int[][] path = new int[][] {
                {1, 2, 2},
                {1, 4, 1},
                {2, 4, 3},
                {2, 5, 10},
                {4, 3, 2},
                {4, 7, 4},
                {4, 6, 8},
                {4, 5, 2},
                {3, 1, 4},
                {3, 6, 5},
                {5, 7, 6},
                {7, 6, 1}
        };

        new DijkstraShortestPath().shortestPath(path, 7, 1);

        List<Integer> list = new ArrayList<>();
        list = list.subList(0, 1);
    }
}
