package twosigma;

import java.util.Arrays;

public class FriendCircles {

    public int findCircleNum(int[][] M) {

        int len = M.length;
        int circles = 0;
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                circles++;
                dfs(i, visited, M);
            }
        }

        return circles;
    }

    public int findCircleNum2(int[][] M) {

        int len = M.length;
        int circles = 0;
        int[] parents = new int[len];
        Arrays.fill(parents, -1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && M[i][j] == 1) {
                    int p1 = find(i, parents);
                    int p2 = find(j, parents);

                    if (p1 != p2) {
                        parents[p1] = p2;
                    }
                }
            }
        }

        for (int p : parents) {
            if (p == -1)
                circles++;
        }

        return circles;
    }

    int find(int i, int[] parents) {
        if (parents[i] == -1)
            return i;
        return find(parents[i], parents);
    }

    void dfs(int v, boolean[] visited, int[][] M) {
        visited[v] = true;

        for (int i = 0; i < M.length; i++) {
            if (i != v && !visited[i] && M[v][i] == 1)
                dfs(i, visited, M);
        }
    }
}
