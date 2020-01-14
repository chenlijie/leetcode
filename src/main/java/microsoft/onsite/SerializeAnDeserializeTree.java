package microsoft.onsite;

import medium.TreeNode;
import utility.Utils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAnDeserializeTree {

    static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        // buildTreeString(root, builder);

        TreeNode cur = root;

        while (cur != null) {

            if (cur.left == null) {
                builder.append(cur.val).append(",X,");

                cur = cur.right;
            } else {
                TreeNode next = cur.left;

                while (next.right != null && next.right != cur)
                    next = next.right;

                if (next.right == null) {
                    builder.append(cur.val).append(",");

                    next.right = cur;
                    cur = cur.left;
                } else {
                    builder.append("X,");

                    next.right = null;
                    cur = cur.right;
                }
            }
        }
        builder.append("X");

        System.out.println(builder.toString());
        return builder.toString();
    }

    static String serialize_2(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        System.out.println(res.toString());
        return res.toString();
    }

    static String serialize_3(TreeNode root) {
        StringBuilder builder = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                builder.append("x,");
            } else {
                builder.append(node.val).append(',');
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        System.out.println(builder.toString());

        return builder.toString();
    }

    static TreeNode deserialize(String data) {
        if (data == null) return null;

        Queue<String> q = new LinkedList<>();
        for (String s : data.split(","))
            q.offer(s);

        TreeNode root = null;
        Queue<TreeNode> nodes = new LinkedList<>();

        while (!q.isEmpty()) {
            if (root == null) {
                String v = q.poll();
                root = new TreeNode(Integer.parseInt(v));
                nodes.offer(root);
            } else {
                TreeNode n = nodes.poll();
                String s = q.poll();
                if (!"x".equals(s)) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(s));
                    n.left = leftNode;
                    nodes.offer(leftNode);
                }

                s = q.poll();
                if (!"x".equals(s)) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(s));
                    n.right = rightNode;
                    nodes.offer(rightNode);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
//        TreeNode node = Utils.buildTree("1,2,X,X,3,4,X,X,5,X,X");
//        serialize(node);
//        serialize_2(node);
//        deserialize(serialize_3(node));


        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 5; i++) {
            map.put(i, i);
        }

        System.out.println(map);

        map.get(2);

        System.out.println(map);
    }
}
