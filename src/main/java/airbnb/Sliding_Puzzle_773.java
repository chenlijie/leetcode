package airbnb;

import java.util.*;

public class Sliding_Puzzle_773 {

    class Node {
        int zeroRow;
        int zeroCol;
        int[][] board;
        Node preNode;
        String boardStr;
        int depth;

        public Node(int zeroRow, int zeroCol, int[][] board, Node preNode, int depth) {
            this.zeroRow = zeroRow;
            this.zeroCol = zeroCol;
            this.board = board;
            this.preNode = preNode;
            boardStr = Arrays.deepToString(board);
            this.depth = depth;
        }
    }

    Node node = null;

    public int slidingPuzzle(int[][] board) {

        String target = Arrays.deepToString(new int[][] { {1,2,3}, {4,5,0}});
        Node start = null;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    start = new Node(i, j, board, null,0);
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start.boardStr);

        int[] dx = new int[] {0,0,1,-1};
        int[] dy = new int[] {1,-1,0,0};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node v = q.poll();

                node = v;
                if (target.equals(v.boardStr)) return v.depth;

                for (int j = 0; j < 4; j++) {
                    int r = v.zeroRow + dx[j];
                    int c = v.zeroCol + dy[j];

//                    int distance = Math.abs(r - v.zeroRow) + Math.abs(c - v.zeroCol);
                    if (r < 0 || r >= 2 || c < 0 || c >= 3)
                        continue;

                    int[][] nextBoard = new int[2][3];
                    for (int k = 0; k < 2; k++) {
                        nextBoard[k] = v.board[k].clone();
                    }
                    swap(nextBoard, r, c, v.zeroRow, v.zeroCol);
                    Node nextNode = new Node(r, c, nextBoard, v, v.depth + 1);

                    if (visited.add(nextNode.boardStr)) {
                        q.offer(nextNode);
                    }

                }
            }
        }

        return -1;
    }

    void swap(int[][] board, int r, int c, int zeroRow, int zeroCol) {
        int t = board[r][c];
        board[r][c] = board[zeroRow][zeroCol];
        board[zeroRow][zeroCol] = t;
    }


    public static void main(String[] args) {
        Sliding_Puzzle_773 slide = new Sliding_Puzzle_773();
        int x = slide.slidingPuzzle(new int[][]{
                {0,1,3},
                {4,2,5}
        });
        System.out.println(x);

        while (slide.node.preNode != null) {
            System.out.println(slide.node.boardStr);
            slide.node = slide.node.preNode;
        }
    }
}
