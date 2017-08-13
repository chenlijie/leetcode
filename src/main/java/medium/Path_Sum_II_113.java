package medium;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 8/12/17.
 */
public class Path_Sum_II_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> possible = new ArrayList<>();
        possible.add(root.val);
        dfs(result, possible, root, sum-root.val);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> possible, TreeNode node, int rest) {

        if (rest == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(possible));
            return;
        }

        if (node.left != null) {
            possible.add(node.left.val);
            dfs(result, possible, node.left, rest-node.left.val);
            possible.remove(possible.size()-1);
        }

        if (node.right != null) {
            possible.add(node.right.val);
            dfs(result, possible, node.right, rest-node.right.val);
            possible.remove(possible.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(-3);

//        root.left = left;
        root.right = right;

        new Path_Sum_II_113().pathSum(root, -5);
    }
}
