package microsoft.onsite;

import javafx.scene.Parent;

import java.util.*;

public class WaterDropShortestPath {

    //求水滴到地面的最短路径 中间有一系列的隔板
    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=368304&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D3%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//    可以认为是李口德那道原题从左上到右下最短路径的变种。
//    题目是给定一个起始点 (x0, y0) 还有一堆木板的两个短点的坐标
//    {{{x1,y1},{x2,y2}},{{x3,y3}, {x4,y4}}} 让你求起始点到地面（y=0) 的最短距离。
//    因为有木板的存在， 所以如果水滴落到木板上就只能向左或者向右流动直到边缘然后再次下落。
//    题目难点是 木板的个数不是一定的， 木板的长度也不是一定的， 整个场景的左右没有边界，
//    水滴不一定落在木板的中心， 也就是是说到木板两端的距离不一定一样。 一眼看去DP是最好的方法，
//    但是第一需要抽象出模型， 由于木板的数量 宽度不一样，可能存在稀疏矩阵的可能
//    （比如一个木板长 1000 个单位 其余的 都只有 10 个以内) 第二个想法是用BFS。
//    但问题是 一无法定义“层”的概念， 二是由于木板长度不同，最少木板的路径不一定最短。
//    加上时间不够， LZ只能想到DFS加上map 进行剪枝

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Board {
        Point leftPoint;
        Point rightPoint;
        Board lefBoard;
        Board rightBoard;
        Set<Board> leftParents = new HashSet<>();
        Set<Board> rightParents = new HashSet<>();

        int toLeft = Integer.MAX_VALUE;
        int toRight = Integer.MAX_VALUE;

        int water_x;
        int distance = Integer.MAX_VALUE;

        public Board(Point leftPoint, Point rightPoint) {
            this.leftPoint = leftPoint;
            this.rightPoint = rightPoint;
        }

        boolean contains(int x) {
            return x > leftPoint.x && x < rightPoint.x;
        }
    }

    static int shortest(List<Board> boards, Point start) {
        Collections.sort(boards, (b1, b2) -> b2.leftPoint.y - b1.leftPoint.y);

        for (int i = 0; i < boards.size(); i++) {
            Board cur = boards.get(i);
            int x1 = cur.leftPoint.x;
            int x2 = cur.rightPoint.x;

            for (int j = i + 1; j < boards.size(); j++) {
                Board b = boards.get(j);
                if (b.leftPoint.y < cur.leftPoint.y) {
                    if (cur.lefBoard == null && b.contains(x1)) {
                        cur.lefBoard = b;
                    }
                    if (cur.rightBoard == null && b.contains(x2)) {
                        cur.rightBoard = b;
                    }
                    if (cur.lefBoard != null && cur.rightBoard != null)
                        break;
                }
            }
        }

        Queue<Board> q = new LinkedList<>();

        for (Board b : boards) {
            if (b.leftPoint.y <= start.y && b.contains(start.x)) {
                b.water_x = start.x;
                b.distance = 0;
                q.offer(b);
                break;
            }
        }

        if (q.isEmpty()) return 0;

        int minPath = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Board v = q.poll();

            int move = v.water_x - v.leftPoint.x;
            if (v.lefBoard == null) {
                minPath = Math.min(minPath, move + v.distance);
            } else {
                Board leftBoard = v.lefBoard;

                if (leftBoard.distance == Integer.MAX_VALUE || v.distance + move < leftBoard.distance) {
                    leftBoard.water_x = v.water_x - move;
                    leftBoard.distance = v.distance + move;
                    q.offer(leftBoard);
                }
            }

            move = v.rightPoint.x - v.water_x;
            if (v.rightBoard == null) {
                minPath = Math.min(minPath, move + v.distance);
            } else {
                Board rightBoard = v.rightBoard;

                if (rightBoard.distance == Integer.MAX_VALUE || v.distance + move < rightBoard.distance) {
                    rightBoard.water_x = v.water_x + move;
                    rightBoard.distance = v.distance + move;
                    q.offer(rightBoard);
                }
            }
        }

        System.out.println("min path: " + minPath);

        return minPath;
    }

    static int shortest_2(List<Board> boards, Point start) {
        Collections.sort(boards, (b1, b2) -> b2.leftPoint.y - b1.leftPoint.y);

        for (int i = 0; i < boards.size(); i++) {
            Board cur = boards.get(i);
            int x1 = cur.leftPoint.x;
            int x2 = cur.rightPoint.x;

            for (int j = i + 1; j < boards.size(); j++) {
                Board b = boards.get(j);
                if (b.leftPoint.y < cur.leftPoint.y) {
                    if (cur.lefBoard == null && b.contains(x1)) {
                        cur.lefBoard = b;
                    }
                    if (cur.rightBoard == null && b.contains(x2)) {
                        cur.rightBoard = b;
                    }
                    if (cur.lefBoard != null && cur.rightBoard != null)
                        break;
                }
            }
        }


        Board startBoard = null;
        for (Board b : boards) {
            if (b.leftPoint.y <= start.y && b.contains(start.x)) {
                startBoard = b;
                b.water_x = start.x;
                b.distance = 0;
                break;
            }
        }

        if (startBoard == null) return 0;

        dfs(startBoard, start.x, 0);

        System.out.println("min = " + min);
        return min;
    }

    static int min = Integer.MAX_VALUE;

    static void dfs(Board board, int x, int dis) {
        if (board == null) {
            min = Math.min(dis, min);
            System.out.println(min);
        } else {
            //move to left
            dfs(board.lefBoard, board.leftPoint.x, dis + x - board.leftPoint.x);
            //move to right
            dfs(board.rightBoard, board.rightPoint.x, dis + board.rightPoint.x - x);
        }
    }

    static int shortest_bfs(List<Board> boards, Point start) {
        Collections.sort(boards, (b1, b2) -> b2.leftPoint.y - b1.leftPoint.y);

        for (int i = 0; i < boards.size(); i++) {
            Board cur = boards.get(i);
            int x1 = cur.leftPoint.x;
            int x2 = cur.rightPoint.x;

            for (int j = i + 1; j < boards.size(); j++) {
                Board b = boards.get(j);
                if (b.leftPoint.y < cur.leftPoint.y) {
                    if (cur.lefBoard == null && b.contains(x1)) {
                        cur.lefBoard = b;
                        b.leftParents.add(cur);
                        b.rightParents.add(cur);
                    }
                    if (cur.rightBoard == null && b.contains(x2)) {
                        cur.rightBoard = b;
                        b.leftParents.add(cur);
                        b.rightParents.add(cur);
                    }
                    if (cur.lefBoard != null && cur.rightBoard != null)
                        break;
                }
            }
        }

        //find board that can reach start point
        Board endBoard = null;
        for (Board b : boards) {
            if (b.lefBoard.leftPoint.y <= start.y && b.contains(start.x)) {
                endBoard = b;
                break;
            }
        }

        if (endBoard == null) return -1;

        Queue<Board> q = new LinkedList<>();
        for (Board b : boards) {
            if (b.lefBoard == null && b.rightBoard == null) {
                b.toLeft = 0;
                b.toRight = 0;
                b.distance = 0;
                q.offer(b);
            }
        }

        while (!q.isEmpty()) {
            Board v = q.poll();

            if (v == endBoard) {
                int shortest = Math.min(v.rightPoint.x - start.x + v.toLeft, start.x - v.leftPoint.x + v.toRight);
                System.out.println("v.distance : " + shortest);
                return shortest;
            }

            for (Board u : v.leftParents) {
                if (v.contains(u.leftPoint.x)) {
                    if (v.rightPoint.x - u.leftPoint.x < u.leftPoint.x - v.leftPoint.x) {
                        u.toLeft = Math.min(u.toLeft, v.toRight + v.rightPoint.x - u.leftPoint.x);
                    } else {
                        u.toLeft = Math.min(u.toLeft, v.toLeft + u.leftPoint.x - v.leftPoint.x);
                    }
                }

                if (!q.contains(u))
                    q.offer(u);
            }

            for (Board u : v.rightParents) {
                if (v.contains(u.rightPoint.x)) {
                    if (v.rightPoint.x - u.rightPoint.x < u.rightPoint.x - v.leftPoint.x) {
                        u.toRight = Math.min(u.toRight, v.toRight + v.rightPoint.x - u.rightPoint.x);
                    } else {
                        u.toRight = Math.min(u.toRight, v.toLeft + u.rightPoint.x - v.leftPoint.x);
                    }
                }

                if (!q.contains(u))
                    q.offer(u);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Board b1 = new Board(new Point(-1, 9), new Point(2, 9));
        Board b2 = new Board(new Point(1, 8), new Point(4, 18));
        Board b3 = new Board(new Point(-6, 7), new Point(3, 7));

        List<Board> boards = new ArrayList<>();
        boards.add(b1);
        boards.add(b2);
        boards.add(b3);

        Point start = new Point(0, 10);

//        shortest_2(boards, start);
        shortest_bfs(boards, start);
    }
}
