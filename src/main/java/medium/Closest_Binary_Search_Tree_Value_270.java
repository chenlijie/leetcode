package medium;

/**
 * Created by chenlijie on 9/5/17.
 */
public class Closest_Binary_Search_Tree_Value_270 {

    //Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

    public int closestValue(TreeNode root, double target) {

        return find(root, target);
    }

    private int find(TreeNode node, double target) {
        if (target < node.val) {

            if (node.left == null || node.val - target < target - node.left.val) {
                return node.val;
            } else {
                return find(node.left, target);
            }
        } else {
            if (node.left == null || node.val - target < target - node.left.val) {
                return node.val;
            } else {
                return find(node.left, target);
            }
        }
    }
}
