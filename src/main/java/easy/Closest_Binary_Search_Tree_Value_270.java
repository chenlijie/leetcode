package easy;

import medium.TreeNode;

/**
 * Created by chenlijie on 9/2/17.
 */
public class Closest_Binary_Search_Tree_Value_270 {

    public int search(TreeNode root, int target) {
        TreeNode node = root;

        while (node != null) {

            int p = Math.abs(node.val - target);

            if (node.left != null && node.right != null) {

                int l = Math.abs(node.left.val - target);
                int r = Math.abs(node.right.val - target);

                if (p < l && p < r) {
                    return node.val;
                } else if (p > l) {
                    node = node.left;
                } else if (p > r) {
                    node = node.right;
                }

            } else if (node.left != null) {
                int l = Math.abs(node.left.val - target);

                if (p < l) {
                    return node.val;
                } else {
                    node = node.left;
                }

            } else if (node.right != null) {

                int r = Math.abs(node.right.val - target);

                if (p < r) {
                    return node.val;
                } else {
                    node = node.right;
                }
            } else {
                return node.val;
            }

        }

        return -1;
    }

    public int closestValue(TreeNode root, double target) {
        // 选出子树的根节点
        TreeNode kid = target < root.val ? root.left : root.right;
        // 如果没有子树，也就是递归到底时，直接返回当前节点值
        if(kid == null) return root.val;
        // 找出子树中最近的那个节点
        int closest = closestValue(kid, target);
        // 返回根节点和子树最近节点中，更近的那个节点
        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }

    public class Solution {
        public int closestValue(TreeNode root, double target) {
            int closest = root.val;
            while(root != null){
                // 如果该节点的离目标更近，则更新到目前为止的最近值
                closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
                // 二叉搜索
                root = target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }
}
