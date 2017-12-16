package hard;

import medium.TreeNode;

import java.util.ArrayList;

/**
 * Created by chenlijie on 11/16/17.
 */
public class Binary_Tree_Maximum_Path_Sum_124 {

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root);

        return max;
    }

    int max = Integer.MIN_VALUE;

    int dfs(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int m = Integer.MIN_VALUE;
        if (left != Integer.MIN_VALUE)
            m = Math.max(left, node.val + left);

        if (right != Integer.MIN_VALUE)
            m = Math.max(right, node.val + right);

        m = Math.max(m, node.val);
        max = Math.max(max, m);

        return m;
    }

    public static void main(String[] args) {
    }
}
