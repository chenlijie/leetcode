package medium;

import java.util.Stack;

public class Validate_Binary_Search_Tree_98 {

    public boolean isValidBST2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null);
    }
    public boolean isValidBST(TreeNode root, TreeNode pre) {

        if (root != null) {
            if (!isValidBST(root.left, pre)) {
                return false;
            }

            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            if (!isValidBST(root.right, pre)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;

        System.out.println(new Validate_Binary_Search_Tree_98().isValidBST(node1));
    }
}
