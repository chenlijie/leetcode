package medium;

import java.util.*;

/**
 * Created by chenlijie on 7/29/17.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();

        findPath(root, p, pList);
        findPath(root, q, qList);

        TreeNode node = null;
        int len = pList.size() < qList.size() ? pList.size() : qList.size();
        for (int i = 0; i < len; i++) {
            if (pList.get(i) == qList.get(i)) {
                node = pList.get(i);
            } else {
                break;
            }
        }

        return node;
    }

    static boolean findPath(TreeNode source, TreeNode target, List<TreeNode> path) {

        if (source == null) {
            return false;
        }

        path.add(source);

        if (source == target) {
            return true;
        }

        if (source.left != null && findPath(source.left, target, path)) {
            return true;
        }

        if (source.right != null && findPath(source.right, target, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(lowestCommonAncestor(root, left, right).val);
    }
}
