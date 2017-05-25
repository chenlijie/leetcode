package medium;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal_94 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list, root);
        return list;
    }

    private void inorderTraversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(list, node.left);
        list.add(node.val);
        inorderTraversal(list, node.right);
    }
    
}
