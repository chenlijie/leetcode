package tree;

import medium.TreeNode;

import java.util.Stack;

/**
 * Created by chenlijie on 11/5/17.
 */
public class InOrder {

    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //visit
            root = stack.pop();
            System.out.print(root.val + " ");

            root = root.right;
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

        node5.right = node6;

        inOrder(root);
    }
}
