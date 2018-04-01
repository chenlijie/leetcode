package ebay;

import medium.TreeNode;

import java.util.LinkedList;

public class SubTreeOfAnotherTree {

    boolean subTree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;

        return check(s, t) || check(s.left, t) || check(s.right, t);
    }

    boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return s.val == t.val && check(s.left, t.left) && check(s.right, t.right);
        }
    }


    static boolean isSubtree(TreeNode s, TreeNode t) {

        StringBuilder builder1 = new StringBuilder(",");
        StringBuilder builder2 = new StringBuilder(",");

        preOrder(s, builder1);
        preOrder(t, builder2);

        return builder1.toString().contains(builder2.toString());
    }

    static void preOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("X,");
        } else {
            builder.append(node.val).append(",");
            preOrder(node.left, builder);
            preOrder(node.right, builder);
        }
    }

    public static void main(String[] args) {
        isSubtree(new TreeNode(12), new TreeNode(2));
        new LinkedList<>();
    }
}
