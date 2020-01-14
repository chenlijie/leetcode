package amazon.onsite;

import java.util.ArrayList;
import java.util.List;

public class WordMatrix {

    static int[][] direc = new int[][] {
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1},
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static void allWords(char[][] matrix) {
        List<String> words = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(i, j, matrix, visited, new StringBuilder(), words);
            }
        }

        System.out.println(words);
    }

    static void dfs(int i, int j, char[][] matrix, boolean[][] visited, StringBuilder builder, List<String> words) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j])
            return;

        visited[i][j] = true;
        int len = builder.length();
        builder.append(matrix[i][j]);

        words.add(builder.toString());

        for (int[] d : direc) {
            int x = i + d[0];
            int y = j + d[1];

            dfs(x, y, matrix, visited, builder, words);
        }

        builder.setLength(len);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };

        allWords(matrix);
    }
}
