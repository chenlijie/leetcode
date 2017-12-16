package medium;

import linkedin.LCA;
import utility.Utils;

import java.util.*;

/**
 * Created by chenlijie on 7/29/17.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

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

    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = findCommonAncestor(root, p, q);

        if (findP && findQ){
            return node;
        }

        return null;
    }

    static boolean findP = false;
    static boolean findQ = false;
    public static TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return root;

        if (root == p) {
            findP= true;
            return root;
        }

        if (root == q) {
            findQ= true;
            return root;
        }

        TreeNode left = findCommonAncestor(root.left, p, q);
        TreeNode right = findCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }



    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

//        System.out.println(lowestCommonAncestor3(node1, node4, node6).val);

        System.out.println(" a".split(" ").length);

        String a = " a ";
        System.out.println(a.trim());
    }
}
