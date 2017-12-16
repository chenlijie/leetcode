package medium;


import java.util.*;

/**
 * Created by chenlijie on 10/23/17.
 */
public class Unique_Binary_Search_Trees_II_95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new ArrayList<>();
        Set<String> dup = new HashSet<>();
        backTracking(n, new int[n + 1], new boolean[n + 1], results, dup, 1);
        return results;
    }

    private void backTracking(int n, int[] array, boolean[] visited, List<TreeNode> results, Set<String> dup, int cur) {
        if (cur-1 == n) {
            TreeNode root = generateTrees(array);
            String str = getPreOrder(root);

            if (!dup.contains(str)) {
                dup.add(str);
                results.add(root);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            array[cur] = i;
            visited[i] = true;
            backTracking(n, array, visited, results, dup, cur + 1);
            visited[i] = false;
        }
    }

    private String getPreOrder(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            return root.val + getPreOrder(root.left) + getPreOrder(root.right);
        }
    }

    private TreeNode generateTrees(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            insertNode(root, array[i]);
        }
        return root;
    }

    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        new Unique_Binary_Search_Trees_II_95().generateTrees(2);
    }
}
