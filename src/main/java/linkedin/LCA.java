package linkedin;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenlijie on 12/11/17.
 */
public class LCA {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode commonAcesstor(TreeNode node, TreeNode left, TreeNode right) {
        Set<TreeNode> parents = new HashSet<>();

        while (left != null) {
            parents.add(left);
            left = left.parent;
        }

        while (right != null) {
            if (parents.contains(right)) {
                return right;
            }
            right = right.parent;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;

        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;

        node3.left = node6;
        node6.parent = node3;

        System.out.println(commonAcesstor(null, node4, node6).val == 1);
        System.out.println(commonAcesstor(null, node2, node5).val == 2);
        System.out.println(commonAcesstor(null, node4, node2).val == 2);
        System.out.println(commonAcesstor(null, node4, node1).val == 1);

        System.out.println(commonAcesstor(null, node4, new TreeNode(7)));
    }

}
