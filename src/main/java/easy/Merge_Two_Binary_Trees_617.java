package easy;

import medium.TreeNode;

/**
 * Created by chenlijie on 7/24/17.
 */
public class Merge_Two_Binary_Trees_617 {

    public class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return traverse(t1, t2);
        }

        public TreeNode traverse(TreeNode t1, TreeNode t2) {

            if (t1 != null && t2 != null) {
                TreeNode node = new TreeNode(t1.val + t2.val);
                node.left = traverse(t1.left, t2.left);
                node.right = traverse(t1.right, t2.right);
                return node;
            }

            return t1 != null ? t1 : t2;
        }

    }
}
