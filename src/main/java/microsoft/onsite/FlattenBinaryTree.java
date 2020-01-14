package microsoft.onsite;

import medium.TreeNode;
import utility.Utils;

public class FlattenBinaryTree {

    static void flatten(TreeNode root) {
        helper_2(root);
    }

    static TreeNode helper(TreeNode node) {
        if (node == null)
            return null;

        TreeNode leftSubTree = helper(node.left);
        TreeNode rightSubTree = helper(node.right);

        if (leftSubTree != null) {
            leftSubTree.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightSubTree == null ? leftSubTree == null ? node : leftSubTree : rightSubTree;
    }

    static TreeNode pre = null;
    static void helper_2(TreeNode node) {
        if (node != null) {
            helper_2(node.right);
            helper_2(node.left);
            node.right = pre;
            node.left = null;
            pre = node;
        }
    }

    static void helper_3(TreeNode node) {
        if (node != null) {
            TreeNode right = node.right;
            if (pre != null) {
                pre.left = null;
                pre.right = node;
            }
            pre = node;

            helper_3(node.left);
            helper_3(right);
        }
    }

    public static void main(String[] args) {
//        TreeNode node = Utils.buildTree("1,2,3,X,X,4,X,X,5,6,X,X,7,X,X");
        TreeNode node = Utils.buildTree("1,2,X,X,3,X,X");

        flatten(node);
        System.out.println(node);
    }
}
