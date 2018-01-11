package linkedin;

import medium.TreeNode;
import utility.Utils;

/**
 * Created by chenlijie on 12/10/17.
 */
public class SecondMinInTree {

    //  binary tree, 每个节点下有0 或2 个子节点，每个节点的值都是两个子节点
    //  的最小值，让你找second min

    static int findSecondMin(TreeNode node) {
        return dfs(node, node.val);
    }

    static int dfs(TreeNode node, int v) {
        if (node == null)
            return v;

        int left = dfs(node.left, v);
        int right = dfs(node.right, v);

        if (left == v) {
            return Math.max(right, node.val);
        }

        if (right == v) {
            return Math.max(left, node.val);
        }

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = Utils.buildTree("1,1,1,5,X,X,1,X,X,5,X,X,2,2,X,X,3,X,X");

        System.out.println(findSecondMin(root));
    }
}
