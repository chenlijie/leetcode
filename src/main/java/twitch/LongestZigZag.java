package twitch;

import medium.TreeNode;
import utility.Utils;

public class LongestZigZag {

    static int max = 0;

    static int longest(TreeNode node) {
        if (node == null)
            return 0;

        helper(node.left, 1,true);
        helper(node.right, 1, false);

        System.out.println(max);
        return max;
    }

    static void helper(TreeNode node, int d, boolean goLeft) {
        if (node == null) {
            max = Math.max(max, d);
            return;
        }

        if (goLeft) {
            //go right
            helper(node.right, d + 1, false);
            //go left
            helper(node.left, 1, true);
        } else {
            //go right
            helper(node.right,1, false);
            //go left
            helper(node.left, d + 1, true);
        }
    }

    static int longest_2(TreeNode node) {
        if (node == null)
            return 0;

        int left = 1 + helper(node.left, true);
        int right = 1 + helper(node.right, false);

        int max = Math.max(left, right);
        return Math.max(max, Math.max(longest_2(node.left), longest_2(node.right)));
    }

    static int helper(TreeNode node, boolean goLeft) {
        if (node == null)
            return 0;

        if (goLeft)
            return 1 + helper(node.right, false);
        else
            return 1 + helper(node.left, true);
    }

    public static void main(String[] args) {
//        TreeNode node = Utils.buildTree("1,2,3,X,X,4,5,X,X,X,6,X,7,8,X,9,10,X,X,X,X");
        TreeNode node = Utils.buildTree("1,2,3,X,X,4,5,X,X,X,6,X,X");

        longest(node);
        System.out.println(longest_2(node));
    }
}
