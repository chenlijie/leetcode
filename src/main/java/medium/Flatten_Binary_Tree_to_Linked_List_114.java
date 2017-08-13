package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 8/12/17.
 */
public class Flatten_Binary_Tree_to_Linked_List_114 {


    public static void flatten(TreeNode root) {

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null) {

            if (node.right != null) {
                stack.push(node.right);
            }


            TreeNode temp = node.left;
            if (temp == null && !stack.isEmpty()) {
                temp = stack.pop();
            }
            node.left = null;
            node.right = temp;
            node = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        left.left = left1;
        left.right = right1;

        TreeNode right2 = new TreeNode(6);
        right.right = right2;

        flatten(root);
        System.out.println(1);
    }
}
