package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94 {


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {

            if (!stack.isEmpty() && stack.peek() == root) {
                stack.pop();
            } else {
                if (root.left != null) {
                    stack.push(root);
                    root = root.left;
                    continue;
                }
            }


            list.add(root.val);

            root = root.right;
            if (root == null && !stack.isEmpty()) {
                root = stack.peek();
            }

        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(inorderTraversal(root));
    }

}