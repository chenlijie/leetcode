package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 5/17/17.
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zigzag = new ArrayList<>();
        LinkedList<TreeNode> zig = new LinkedList<>();
        LinkedList<TreeNode> zag = new LinkedList<>();

        if (root != null) {
            zig.add(root);
        }

        while (!zig.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            while (!zig.isEmpty()) {
                TreeNode node = zig.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    zag.add(node.left);
                }
                if (node.right != null) {
                    zag.add(node.right);
                }
            }
            if (list.size() != 0) {
                zigzag.add(list);
            }

            list = new ArrayList<>();
            while (!zag.isEmpty()) {
                TreeNode node = zag.pollLast();
                list.add(node.val);
                if (node.right != null) {
                    zig.addFirst(node.right);
                }
                if (node.left != null) {
                    zig.addFirst(node.left);
                }
            }
            if (list.size() != 0) {
                zigzag.add(list);
            }
        }

        return zigzag;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        zigzagLevelOrder(root);
    }
}
