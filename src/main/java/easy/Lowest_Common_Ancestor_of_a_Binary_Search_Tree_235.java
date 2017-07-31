package easy;

import medium.TreeNode;

/**
 * Created by chenlijie on 7/29/17.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }

        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }

        TreeNode left = null;
        TreeNode right = null;

        if (root.val > p.val && root.val > q.val) {
            left = lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        return left != null ? left : right;

    }

    public static void main(String[] args) {
        //[6,2,8,0,4,7,9,null,null,3,5]
//        node with value 3
//        node with value 5
        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;

        TreeNode leftL = new TreeNode(0);
        TreeNode leftR = new TreeNode(4);
        left.left = leftL;
        left.right = leftR;

        TreeNode rightL = new TreeNode(7);
        TreeNode rightR = new TreeNode(9);
        right.left = rightL;
        right.right = rightR;

        TreeNode left3 = new TreeNode(3);
        TreeNode right5 = new TreeNode(5);
        leftR.left  = left3;
        leftR.right = right5;

        System.out.println(lowestCommonAncestor(root, left3, right5).val);
    }
}
