package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Symmetric_Tree_101 {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right == null) {
            return false;
        }

        if (root.left == null && root.right != null) {
            return false;
        }

        if (root.left.val != root.right.val) {
            return false;
        }

        LinkedList<TreeNode> list1 = new LinkedList<>();
        list1.add(root.left);
        list1.add(root.right);

        while (!list1.isEmpty()) {
            LinkedList<TreeNode> list2 = new LinkedList<>();
            while (!list1.isEmpty()) {
                TreeNode node1 = list1.pollFirst();
                TreeNode node2 = list1.pollLast();

                if (node1.left == null && node2.right != null) {
                    return false;
                }

                if (node1.left != null && node2.right == null) {
                    return false;
                }

                if (node1.left != null && node1.left.val != node2.right.val) {
                    return false;
                }

                if (node1.left != null) {
                    list2.addFirst(node1.left);
                    list2.addLast(node2.right);
                }

                if (node1.right == null && node2.left != null) {
                    return false;
                }

                if (node1.right != null && node2.left == null) {
                    return false;
                }

                if (node1.right != null && node1.right.val != node2.left.val) {
                    return false;
                }
                if (node1.right != null){
                    list2.addFirst(node1.right);
                    list2.addLast(node2.left);
                }
            }
            list1.addAll(list2);
        }

        return true;
    }

    public static void main(String[] args) {
        Symmetric_Tree_101.TreeNode root = new Symmetric_Tree_101.TreeNode(1);
        Symmetric_Tree_101.TreeNode root1 = new Symmetric_Tree_101.TreeNode(2);
        Symmetric_Tree_101.TreeNode root2 = new Symmetric_Tree_101.TreeNode(2);
        Symmetric_Tree_101.TreeNode root11 = new Symmetric_Tree_101.TreeNode(4);
        Symmetric_Tree_101.TreeNode root12 = new Symmetric_Tree_101.TreeNode(3);
        Symmetric_Tree_101.TreeNode root21 = new Symmetric_Tree_101.TreeNode(4);
        Symmetric_Tree_101.TreeNode root22 = new Symmetric_Tree_101.TreeNode(4);

        root.left = root1;
        root.right = root2;
        root1.left = root11;
//        root1.right = root12;
        root2.left = root21;
//        root2.right = root22;

        System.out.println(isSymmetric(root));
    }
}
