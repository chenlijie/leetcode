package hard;

import medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_Binary_Tree_297 {

    static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildTreeString(root, builder);
        return builder.toString();
    }

    static void buildTreeString(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("X").append(",");
            return;
        }

        builder.append(node.val).append(",");
        buildTreeString(node.left, builder);
        buildTreeString(node.right, builder);
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        String[] str = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : str) {
            queue.offer(s);
        }

        return buildTree(queue);
    }

    static TreeNode buildTree(Queue<String> queue) {
        if (queue.isEmpty())
            return null;

        String val = queue.poll();
        if ("X".equals(val)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode node = deserialize("X,");
        System.out.println(node);

        System.out.println(serialize(null));
    }
}
