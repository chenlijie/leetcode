package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenlijie on 8/10/17.
 */
public class Binary_Tree_Preorder_Traversal_144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode dummy = new TreeNode(0);
        dummy.right = root;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(dummy);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop().right;

            while (node != null) {
                stack.add(node);
                list.add(node.val);
                node = node.left;
            }
        }

        return list;
    }

    private void travesal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (node.left != null) {
            travesal(node.left, list);
        }

        if (node.right != null) {
            travesal(node.right, list);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode right = new TreeNode(2);
        root.right = right;

        TreeNode left = new TreeNode(3);
        right.left = left;

        for (int i : preorderTraversal(root)) {
            System.out.print(i + " ");
        }
    }
}
