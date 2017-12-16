package tree;

import medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/14/17.
 */
public class EraseTreeNode {

    boolean shouldBeErase(TreeNode node) {
        if (node.val == 1
                || node.val == 5
                || node.val == 6
                || node.val == 7
                || node.val == 4
                || node.val == 3) {
            return true;
        }
        return false;
    }

    List<TreeNode> erase(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        erase(root, null, result);
        return result;
    }

    TreeNode erase(TreeNode node, TreeNode root, List<TreeNode> result) {
        if (node == null) {
            return null;
        }
        if (shouldBeErase(node)) {
            erase(node.left, null, result);
            erase(node.right, null, result);
            return null;
        } else {
            if (root == null) {
                result.add(node);
            }
            node.left = erase(node.left, node, result);
            node.right = erase(node.right, node, result);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node3.left = node6;
        node3.right = node7;

        TreeNode node8 = new TreeNode(8);
        node4.left = node8;

        new EraseTreeNode().erase(node1);
    }
}
