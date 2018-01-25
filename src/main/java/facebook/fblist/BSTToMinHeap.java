package facebook.fblist;

import medium.TreeNode;
import tree.Tree;
import utility.Utils;

import java.util.*;

public class BSTToMinHeap {

    //Given a binary search tree which is also a complete binary tree.
    static void convert(TreeNode node) {
        if (node == null)
            return;

        helper(node);
        convert(node.left);
        convert(node.right);
    }

    static void helper(TreeNode node) {
        if (node == null || node.left == null)
            return;

        helper(node.left);
        helper(node.right);

        //compare node and left node
        if (node.val > node.left.val) {
            swap(node, node.left);
        }

        if (node.right != null && node.left.val > node.right.val) {
            swap(node.left, node.right);
        }
    }

    static void swap(TreeNode node1, TreeNode node2) {
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
    }

    static void convert2(TreeNode root) {
        Queue<Integer> inOrder = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            //visit node
            node = stack.pop();
            inOrder.add(node.val);

            //go to visit right node
            node = node.right;
        }

        //pre order traversal
        preOrder(root, inOrder);

    }

    static void preOrder(TreeNode node, Queue<Integer> vals) {
        if (node == null)
            return;

        node.val = vals.poll();
        preOrder(node.left, vals);
        preOrder(node.right, vals);
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("4,2,1,X,X,3,X,X,6,5,X,X,7,X,X");
        convert2(node);

        Utils.printInOrderTreeNode(node);
    }
}
