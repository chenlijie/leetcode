package tree;

import medium.TreeNode;

import java.util.Stack;

/**
 * Created by chenlijie on 10/14/17.
 */
public class TreeIteration {

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void inOrderIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void preOrderIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

//        System.out.println("In order iteration");
//        inOrder(node1);
//        System.out.println();
//        inOrderIter(node1);

//        System.out.println("Pre order iteration");
//        preOrder(node1);
//        System.out.println();
//        preOrderIter(node1);

        System.out.println("Post order iteration");
        preOrder(node1);
        System.out.println();
        preOrderIter(node1);
    }
}
