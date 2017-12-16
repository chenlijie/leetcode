package hard;

import medium.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by chenlijie on 11/17/17.
 */
public class Recover_Binary_Search_Tree_99 {

    public void recoverTree(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;

        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (pre != null && pre.val > node.val) {
                if (first == null) {
                    first = pre;
                }

                if (first != null){
                    second = node;
                }
            }
            pre = node;
            node = node.right;
        }

        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        } else if (first != null) {
            int t = first.val;
            first.val = root.val;
            root.val = t;
        }
    }

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree2(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }

    public static void main(String[] args) {
        Recover_Binary_Search_Tree_99 r = new Recover_Binary_Search_Tree_99();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        r.recoverTree(node1);

        System.out.println(node1);

    }

}
