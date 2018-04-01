package ebay;

import medium.TreeNode;
import utility.Utils;

import java.util.*;

public class PrintBinaryTreeInVerticalOrder {

    static class Pair {
        TreeNode node;
        int d;

        public Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    static void print_2(TreeNode node) {
        if (node == null) return;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node, 0));
        Map<Integer, List<Integer>> map = new TreeMap<>();

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
                Pair v = q.poll();
                map.putIfAbsent(v.d, new ArrayList<>());
                map.get(v.d).add(v.node.val);

                if (v.node.left != null)
                    q.offer(new Pair(v.node.left, v.d - 1));
                if (v.node.right != null)
                    q.offer(new Pair(v.node.right, v.d + 1));
            }
        }
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            System.out.println(e.getValue());
        }

    }

    static void print(TreeNode node) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        dfs(node, 0, map);

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            System.out.println(e.getValue());
        }
    }

    static void dfs(TreeNode node, int i, Map<Integer, List<Integer>> map) {
        if (node == null) return;

        map.putIfAbsent(i, new ArrayList<>());
        map.get(i).add(node.val);

        dfs(node.left, i - 1, map);
        dfs(node.right, i + 1, map);
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,2,4,X,X,5,X,10,X,X,3,6,X,X,7,X,9,X,X");
        print(node);
        System.out.println("-------------------------");
        print_2(node);
    }
}
