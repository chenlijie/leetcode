package easy;

import medium.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 1/10/18.
 */
public class Path_Sum_III_437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int dfs(TreeNode node, int sum, int target) {
        if (node == null) return 0;

        sum += node.val;

        return (target == sum ? 1 : 0)
                + dfs(node.left, sum, target)
                + dfs(node.right, sum, target);
    }

    public static void main(String[] args) {
        Path_Sum_III_437 sum = new Path_Sum_III_437();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightright = new TreeNode(3);
        root.right = right;
        right.right = rightright;

        System.out.println(sum.pathSum(root, 3));
    }
}
