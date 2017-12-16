package tree;

import medium.TreeNode;

import java.util.Stack;

/**
 * Created by chenlijie on 11/5/17.
 */
public class PreOrder {

    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {

            //visit
            System.out.print(root.val + " ");

            if (root.right != null) {
                stack.push(root.right);
            }

            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
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

        node5.left = node6;

        preOrder(root);
    }
}
