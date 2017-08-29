package sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/26/17.
 */
public class Friend_Circles_547 {

    public int findCircleNum(int[][] M) {
        int num = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {

            if (M[i][i] == 1) {
                num++;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int f = queue.poll();
                    M[f][f] = -1;

                    for (int k = 0; k < M.length; k++) {
                        if (M[f][k] == 1) {
                            M[f][k] = -1;
                            M[k][f] = -1;
                            queue.offer(k);
                        }
                    }
                }
            }
        }

        return num;
    }

    public int findCircleNum2(int[][] M) {
        int[] parents = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            parents[i] = i;
        }

        int groups = M.length;

        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    int p1 = find(i, parents);
                    int p2 = find(j, parents);
                    if (p1 != p2) {
                        parents[p1] = p2;
                        groups--;
                    }
                }
            }
        }

        return groups;
    }

    private int find(int i, int[] parents) {
        return parents[i] == i ? i : find(parents[i], parents);
    }


    public static void main(String[] args) {
        System.out.println(new Friend_Circles_547().findCircleNum2(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}

//                {1,1,0},
//                {1,1,0},
//                {0,0,1}
        }));
    }
}
