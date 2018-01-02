package facebook;

import medium.TreeNode;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/24/17.
 */
public class PrintPathToLeaf {

    static void print(TreeNode node) {
        helper(node, new ArrayList<>());
    }

    static void helper(TreeNode node, List<Integer> path) {
        if (node == null)
            return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            System.out.println(path);
            return;
        }

        if (node.left != null) {
            helper(node.left, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            helper(node.right, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,2,4,X,X,X,3,5,X,X,6,X,X");
//        TreeNode node = Utils.buildTree("1,2,X,X,3,X,X");
        print(node);
    }
}
