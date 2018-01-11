package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlijie on 1/6/18.
 */
public class Longest_Increasing_Path_in_a_Matrix_329 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        List[][] dis = new List[m][n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> path = new ArrayList<>();
                dfs(matrix, Integer.MIN_VALUE, i, j, m, n, dis, path, ans);
            }
        }

        System.out.println(ans);
        return ans.size();
    }

    void dfs(int[][] matrix, int pre, int i, int j, int m, int n, List[][] dis, List<Integer> path, List<Integer> ans) {

        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= pre) {
            if (path.size() > ans.size()) {
                ans.clear();
                ans.addAll(path);
            }
            return;
        }

        if (dis[i][j] != null) {
            if (dis[i][j].size() + path.size() > ans.size()) {
                ans.clear();
                ans.addAll(path);
                ans.addAll(dis[i][j]);
            }
            return;
        }

        int[][] dct = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int curLen = path.size();

        List<Integer> subList = new ArrayList<>();
        subList.add(matrix[i][j]);

        path.add(matrix[i][j]);

        for (int[] d : dct) {
            int x = i + d[0];
            int y = j + d[1];

            dfs(matrix, matrix[i][j], x, y, m, n, dis, path, ans);
            List<Integer> temp = path.subList(curLen, path.size());

            if (temp.size() > subList.size()) {
                subList.clear();
                subList.addAll(temp);
            }
        }

        dis[i][j] = subList;
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        Longest_Increasing_Path_in_a_Matrix_329 m = new Longest_Increasing_Path_in_a_Matrix_329();
        int len = m.longestIncreasingPath(new int[][]{
                {9,9,4},{6,6,8},{2,1,1}
//                {1,2,3}
//                {0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}
        });
        System.out.println(len);
    }
}
