package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 11/6/17.
 */
public class Inorder_Successor_in_BST_285 {

    /**
     Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

     Note: If the given node has no in-order successor in the tree, return null.
     */
    static TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre == p) {
                return root;
            }
            pre = root;
            root = root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node5;

        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);

        node2.left = node1;
        node2.right = node3;

        node5.right = node6;

        System.out.println(inOrderSuccessor(root, root).val);
    }
}
