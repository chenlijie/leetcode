package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 8/13/17.
 */
public class Kth_Smallest_Element_in_a_BST_230 {

    public int kthSmallest(TreeNode root, int k) {

        int l = countNodes(root.left);

        if (k == (l+1)) {
            return root.val;
        } else if (k < (l+1)) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k-l-1);
        }
    }

    private int countNodes(TreeNode node) {
        return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int kthSmallest2(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (k != 0) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (--k == 0) {
                return node.val;
            }

            node = node.right;
        }

        return -1;
    }


    public int kthSmallest3(TreeNode root, int k) {

        return -1;
    }

    private void dfs(TreeNode node, int k, TreeNode find) {

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
//
//        right1.left = right11;
//        right1.right = right12;


        System.out.println(new Kth_Smallest_Element_in_a_BST_230().kthSmallest(root, 5));
        System.out.println(new Kth_Smallest_Element_in_a_BST_230().kthSmallest2(root, 5));

    }
}
