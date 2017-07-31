package easy;

import medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 7/29/17.
 */
public class Binary_Tree_Paths_257 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new ArrayList<>();

        path(root, null, list);

        return list;
    }

    void path(TreeNode node, String s, List<String> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (s == null) {
                list.add(String.valueOf(node.val));
            } else {
                list.add(s + "->" + node.val);
            }
        }

        if (node.left != null) {
            if (s == null) {
                path(node.left, String.valueOf(node.val), list);
            } else {
                path(node.left, s + "->" + node.val, list);
            }
        }

        if (node.right != null) {
            if (s == null) {
                path(node.right, String.valueOf(node.val), list);
            } else {
                path(node.right, s + "->" + node.val, list);
            }
        }
    }
}
