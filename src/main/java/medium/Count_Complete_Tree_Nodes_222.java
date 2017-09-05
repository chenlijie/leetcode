package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/11/17.
 */
public class Count_Complete_Tree_Nodes_222 {

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);

        if (l == r) {
            //if height of left subtree and right subtree is same, then left subtree is full complete tree.
            return l == -1 ? 1 : (1 << (l+1)) + countNodes(root.right);
        } else {
            //if height of left subtree is larger than right subtree, then right subtree is full complete tree.
            return countNodes(root.left) + (1 << (r+1));
        }
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + height(node.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);

        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(5);

        TreeNode right1 = new TreeNode(3);

        TreeNode right11 = new TreeNode(6);
        TreeNode right12 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        left1.left = left11;
        left1.right = left12;

        right1.left = right11;
        right1.right = right12;


        System.out.println(countNodes(null));

    }

}
