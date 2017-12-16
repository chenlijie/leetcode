package medium;

import utility.Utils;

/**
 * Created by chenlijie on 12/14/17.
 */
public class Binary_Tree_Upside_Down_156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfs(root);
    }

    TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        TreeNode right = dfs(node.right);
        TreeNode left = dfs(node.left);

        if (left != null) {
            left.left = right;
            left.right = node;
            return left;
        }

        return left;
    }

    public static void main(String[] args) {
        TreeNode node1 = Utils.buildTree("1,2,X,X,3,X,X");

        Binary_Tree_Upside_Down_156 down = new Binary_Tree_Upside_Down_156();
        TreeNode node = down.dfs(node1);
        System.out.println(node.val);
    }
}
