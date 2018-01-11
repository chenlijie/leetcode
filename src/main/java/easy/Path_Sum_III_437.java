package easy;

import medium.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 1/10/18.
 */
public class Path_Sum_III_437 {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] ans = new int[1];
        helper(root, 0, sum, map, ans);
        return ans[0];
    }

    void helper(TreeNode node, int sum, int target, Map<Integer, Integer> map, int[] ans) {
        if (node == null)
            return;

        sum += node.val;

        ans[0] += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        helper(node.left, sum, target, map, ans);
        helper(node.left, sum, target, map, ans);

        map.put(sum, map.get(sum) - 1);
    }

    public static void main(String[] args) {
        Path_Sum_III_437 sum = new Path_Sum_III_437();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        left.val = 3;
        root.left = left;
        System.out.println(sum.pathSum(root, 3));
    }
}
