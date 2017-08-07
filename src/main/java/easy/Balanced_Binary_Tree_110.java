package easy;

import medium.TreeNode;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Balanced_Binary_Tree_110 {

    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        depth(root);

        return balanced;

    }

    int depth(TreeNode node) {
        if (node == null || !balanced) {
            return 0;
        }

        int left = depth(node.left) + 1;
        int right = depth(node.right) + 1;

        if (Math.abs(left-right) > 1) {
            balanced = false;
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;
        node2.left = node3;

        System.out.println(new Balanced_Binary_Tree_110().isBalanced(node1));
    }
}
