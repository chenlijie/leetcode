package amazon.onsite;

import java.util.*;

public class CutGolf {

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                q.offer(new int[] {i, j, forest.get(i).get(j)});
            }
        }

        int minSteps = 0;
        int[] start = new int[] {0, 0, 0};

        while (!q.isEmpty()) {
            int[] v = q.poll();

            int step = bfs(forest, start, v);
            if (step == -1)
                return -1;

            minSteps += step;
            start = v;
        }

        return minSteps;
    }

    int[][] dirc = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1} };

    int bfs(List<List<Integer>> f, int[] start, int[] end) {
        boolean[][] visited = new boolean[f.size()][f.get(0).size()];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] v = q.poll();
                if (v[0] == end[0] && v[1] == end[1])
                    return step;

                for (int[] d : dirc) {
                    int x = d[0] + v[0];
                    int y = d[1] + v[1];

                    if (x >= 0 && x < f.size() && y >= 0 && y < f.get(0).size() && !visited[x][y] && f.get(x).get(y) != 0) {
                        q.offer(new int[] {x, y});
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public static void main(String[] args) {
        CutGolf golf = new CutGolf();
        int s = golf.cutOffTree(Arrays.asList(Arrays.asList(54581641,64080174,24346381,69107959),
                Arrays.asList(86374198,61363882,68783324,79706116),
                Arrays.asList(668150,92178815,89819108,94701471),
                Arrays.asList(83920491,22724204,46281641,47531096),
                Arrays.asList(89078499,18904913,25462145,60813308)));
        System.out.println(s);
    }
}
