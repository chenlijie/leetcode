package zillow;

import medium.TreeNode;
import utility.Utils;

public class ValidateBST {

    static TreeNode pre = null;

    static boolean isValidBST(TreeNode node) {
        if (node == null) return true;

        boolean valid = isValidBST(node.left);

        if (!valid) return false;

        if (pre != null && node.val <= pre.val) return false;

        pre = node;

        return isValidBST(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,1,X,X");
        System.out.println(isValidBST(node));
    }
}
