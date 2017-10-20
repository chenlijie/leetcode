package graph;

import medium.TreeNode;

/**
 * Created by chenlijie on 10/18/17.
 */
public class CommonAncestor {

    static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p && root == q) return root;

        TreeNode x = commonAncestor(root.left, p, q);
        if (x != null && x != p && x != q) { // Already found ancestor
            return x;
        }
        TreeNode y = commonAncestor(root.right, p, q);
        if (y != null && y != p && y != q) { // Already found ancestor
            return y;
        }

        if (x != null && y != null) { // p and q found in diff. subtrees
            return root; // This is the common ancestor
        } else if (root == p || root == q) {
            return root;
        } else {
            return x == null ? y : x;
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        p.left = q;

        TreeNode root = new TreeNode(3);
        root.left = p;

        System.out.println(commonAncestor(root, p, q).val);
    }
}
