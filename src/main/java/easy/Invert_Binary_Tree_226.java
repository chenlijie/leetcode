package easy;

public class Invert_Binary_Tree_226 {

    public static TreeNode invertTree(TreeNode root) {

        if (root != null) {
            TreeNode temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
