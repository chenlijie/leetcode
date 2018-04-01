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

    static TreeNode lca(TreeNode node1, TreeNode node2) {
        int d1 = getDepth(node1);
        int d2 = getDepth(node2);

        if (d1 < d2) {
            return getCommonNode(node2, node1, d2 - d1);
        } else {
            return getCommonNode(node1, node2, d1 - d2);
        }
    }

    private static TreeNode getCommonNode(TreeNode node1, TreeNode node2, int diff) {
        while (diff-- > 0) {
            node1 = node1.parent;
        }

        while (node1 != node2) {
            node1= node1.parent;
            node2 = node2.parent;
        }
        return node1;
    }

    private static int getDepth(TreeNode node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.parent;
        }
        return d;
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
        node2.parent = node1;
        node3.parent = node1;

        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;

        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node6.parent = node3;

        System.out.println(lca(node4, node6) == null ?  lca(node4, node6) : lca(node4, node6).val);
        System.out.println(lca(node4, node3) == null ?  lca(node4, node3) : lca(node4, node3).val);
        System.out.println(lca(node4, node1) == null ?  lca(node4, node1) : lca(node4, node1).val);
        System.out.println(lca(node4, node2) == null ?  lca(node4, node2) : lca(node4, node2).val);

        System.out.println(lca(node3, node4) == null ?  lca(node3, node4) : lca(node3, node4).val);
        System.out.println(lca(node1, node4) == null ?  lca(node1, node4) : lca(node1, node4).val);
        System.out.println(lca(node2, node4) == null ?  lca(node2, node4) : lca(node2, node4).val);


        System.out.println(lca(null, null) == null ?  lca(null, null) : lca(null, null).val);
        System.out.println(lca(node4, null) == null ?  lca(node4, null) : lca(node4, null).val);
        System.out.println(lca(null, node2) == null ?  lca(null, node2) : lca(null, node2).val);

//        System.out.println(commonAcesstor(null, node4, node6).val == 1);
//        System.out.println(commonAcesstor(null, node2, node5).val == 2);
//        System.out.println(commonAcesstor(null, node4, node2).val == 2);
//        System.out.println(commonAcesstor(null, node4, node1).val == 1);
//        System.out.println(commonAcesstor(null, node4, new TreeNode(7)));
    }

}
