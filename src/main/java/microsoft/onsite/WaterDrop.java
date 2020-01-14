package microsoft.onsite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaterDrop {
    
    private static class Node {
        Node left;
        Node right;
        
        int left_x;
        int right_x;
        int y;

        int toLeft = Integer.MAX_VALUE;
        int toRight = Integer.MAX_VALUE;
        
        int distance = Integer.MAX_VALUE;

        public Node(int left_x, int right_x, int y) {
            this.left_x = left_x;
            this.right_x = right_x;
            this.y = y;
        }

        boolean contains(int x) {
            return left_x < x && x < right_x;
        }
        
    }
    
    static void shortestPath(List<Node> nodes, int x, int y) {
        nodes.sort((n1, n2) -> n2.y - n1.y);

        for (int i = 0; i < nodes.size(); i++) {
            Node parent = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node child = nodes.get(j);
                if (parent.left == null && child.contains(parent.left_x)) {
                    parent.left = child;
                }
                if (parent.right == null && child.contains(parent.right_x)) {
                    parent.right = child;
                }
                if (parent.left != null && parent.right != null) break;
            }
        }
        
        Node start = null;
        for (Node node : nodes) {
            if (node.y < y && node.contains(x)) {
                start = node;
                start.distance = 0;
                start.toLeft = x - start.left_x;
                start.toRight = start.right_x - x;
                break;
            }
        }

        if (start == null) return;
        //bfs
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.left != null) {
                node.left.toLeft = Math.min(node.left.toLeft, node.toLeft + node.left_x - node.left.left_x);
                node.left.toRight = Math.min(node.left.toRight, node.toLeft + node.left.right_x - node.left_x);
                q.offer(node.left);
            } else {
                min = Math.min(min, node.toLeft);
            }

            if (node.right != null) {
                node.right.toLeft = Math.min(node.right.toLeft, node.toRight + node.right_x - node.right.left_x);
                node.right.toRight = Math.min(node.right.toRight, node.toRight + node.right.right_x - node.right_x);
                if (node.right != node.left) {
                    q.offer(node.right);
                }
            }else {
                min = Math.min(min, node.toRight);
            }

        }

//        dfs(start, x, 0);
    }

    static int min = Integer.MAX_VALUE;
    
    private static void dfs(Node node, int x, int dis) {
        if (node == null) {
            min = Math.min(min, dis);
        } else {
            //go to left
            dfs(node.left, node.left_x, dis + x - node.left_x);

            //go to right
            dfs(node.right, node.right_x, dis + node.right_x - x);
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(-1, 2, 9);
        Node node2 = new Node(0, 5, 8);
        Node node3 = new Node(-16, 5, 7);
//        Node node4 = new Node(-6, 0, 8);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
//        nodes.add(node4);

        shortestPath(nodes, 0, 10);
        System.out.println(min);
    }
}
