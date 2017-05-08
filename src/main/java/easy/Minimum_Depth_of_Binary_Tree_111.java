package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree_111 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 1);
    }

    /**
     *
     * Both node.left.left and node.left.right are null or both node.right.left and node.right.right are null, we find the min depth.
     *
     * Either node.left.left or node left.right is not null and either node.left.left or node left.right is not null, we keep checking child node.
     *
     *          1
     *        2
     *      4   5
     *    6   7
     *
     */
    private static int minDepth(TreeNode node, int level) {
        if (node.left == null && node.right == null)
            return level;

        if (node.left != null && node.left.left == null && node.left.right == null)
            return level+1;

        if (node.right != null && node.right.left == null && node.right.right == null)
            return level+1;

        if (node.left != null && node.right == null)
            return minDepth(node.left, level+1);

        if (node.right != null && node.left == null)
            return minDepth(node.right, level+1);

        return Math.min(minDepth(node.left, level+1), minDepth(node.right, level+1));
    }

    /**
     * If both node.left and node.right are null, it's leaf node.
     * If either node.left or node.right is not null, keep tracking them.
     *
     *
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        return minDepth2(root, 1);
    }

    private static int minDepth2(TreeNode node, int level) {
        if (node.left == null && node.right == null)
            return level;

        if (node.left != null && node.right == null)
            return minDepth2(node.left, level+1);

        if (node.right != null && node.left == null)
            return minDepth2(node.right, level+1);

        return Math.min(minDepth2(node.left, level+1), minDepth2(node.right, level+1));
    }

    /**
     * BFS
     */
    public static int minDepth3(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int min = 0;
        int size;
        while (!queue.isEmpty()) {
            min ++;
            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return min;

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return min;
    }

    /**
     *  [-9,-3,2,null,4,4,0,-6,null,-5]
     *
     *
     *               -9
     *            -3     2
     *              4  4  0
     *           -6   5
     *
     */
    public static void main(String[] args) {
        Minimum_Depth_of_Binary_Tree_111.TreeNode root = new Minimum_Depth_of_Binary_Tree_111.TreeNode(-9);
        Minimum_Depth_of_Binary_Tree_111.TreeNode left = new Minimum_Depth_of_Binary_Tree_111.TreeNode(-3);
        Minimum_Depth_of_Binary_Tree_111.TreeNode right = new Minimum_Depth_of_Binary_Tree_111.TreeNode(2);
        root.left = left;
        root.right = right;

//        Minimum_Depth_of_Binary_Tree_111.TreeNode left2 = new Minimum_Depth_of_Binary_Tree_111.TreeNode(4);
        Minimum_Depth_of_Binary_Tree_111.TreeNode right2 = new Minimum_Depth_of_Binary_Tree_111.TreeNode(4);
        left.left = null;
        left.right = right2;

        Minimum_Depth_of_Binary_Tree_111.TreeNode left3 = new Minimum_Depth_of_Binary_Tree_111.TreeNode(4);
        Minimum_Depth_of_Binary_Tree_111.TreeNode right3 = new Minimum_Depth_of_Binary_Tree_111.TreeNode(0);
        right.left = left3;
        right.right = right3;

        Minimum_Depth_of_Binary_Tree_111.TreeNode left4 = new Minimum_Depth_of_Binary_Tree_111.TreeNode(-6);
        right2.left = left4;

        Minimum_Depth_of_Binary_Tree_111.TreeNode left5 = new Minimum_Depth_of_Binary_Tree_111.TreeNode(5);
        left4 = left5;

        System.out.println(minDepth3(root));

    }

}
