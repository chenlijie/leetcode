package medium;

import java.util.*;

/**
 * Created by chenlijie on 11/7/17.
 */
public class Binary_Tree_Vertical_Order_Traversal_314 {

    static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrder(root, 0, map);
        return new ArrayList<>(map.values());
    }

    static void verticalOrder(TreeNode root, int p, Map<Integer, List<Integer>> map) {
        if (root != null) {
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(root.val);
            verticalOrder(root.left, p-1, map);
            verticalOrder(root.right, p+1, map);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        node1.left = node9;
        node1.right = node20;
        node9.left = node4;
        node9.right = node5;
        node20.left = node2;
        node20.right = node7;

        System.out.println(verticalOrder(node1));

        LinkedList<Integer> list = new LinkedList<>();
    }

}
