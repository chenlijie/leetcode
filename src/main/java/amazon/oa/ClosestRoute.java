package amazon.oa;

public class ClosestRoute {

    public int closestRoute(int[][] matrix) {
        if (matrix.length == 0) return 0;
        return help(matrix, 0, 0, new boolean[matrix.length][matrix[0].length]) - 1;
    }

    int[][] dirc = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

    private int help(int[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0 || visited[i][j])
            return 0;

        if (matrix[i][j] == 9) return 1;

        visited[i][j] = true;
        int min = Integer.MAX_VALUE;

        for (int[] d : dirc) {
            int x = d[0] + i;
            int y = d[1] + j;

            int step = help(matrix, x, y, visited);
            if (step > 0) {
                min = Math.min(min, step + 1);
            }
        }

        visited[i][j] = false;

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        ClosestRoute route = new ClosestRoute();

        int[][] m = new int[][] {
                {1, 1, 1, 1},
                {1, 1, 1, 9},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };

        System.out.println(route.closestRoute(m) == 4);

        m = new int[][] {
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {9, 1, 0, 1},
                {1, 1, 1, 1},
        };

        System.out.println(route.closestRoute(m) == 10);

        m = new int[][] {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 9, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 1},
        };

        System.out.println(route.closestRoute(m) == -1);
    }
}
