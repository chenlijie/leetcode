package ebay;

import medium.TreeNode;
import utility.Utils;

public class ImmediateLargerElementInBST {

//    given a num, find the immediate larger element in a BST.
//    num may be not in the BST

    static int find(TreeNode node, int k) {
        return helper(node, -1, k);
    }

    static int helper(TreeNode node, int n, int k) {
        if (node == null)
            return n;

        if (node.val > k) {
            return helper(node.left, node.val, k);
        } else {
            return helper(node.right, n, k);
        }
    }

    public static void main(String[] args) {
//        TreeNode node = Utils.buildTree("5,3,X,X,7,X,X");
        TreeNode node = Utils.buildTree("10,1,20,X,X,X,X");
        System.out.println(find(node, 100));
    }
}
