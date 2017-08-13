package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/12/17.
 */
public class Add_One_Row_to_Tree_623 {

    public static TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return  node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(root);

        while (depth < d-1 && !queue.isEmpty()) {

            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = new TreeNode(v);
            left.left = node.left;
            node.left = left;

            TreeNode right = new TreeNode(v);
            right.right = node.right;
            node.right = right;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(1);
        left.left = left1;
        left.right = right1;

        addOneRow(root, 1, 3);

    }
}
