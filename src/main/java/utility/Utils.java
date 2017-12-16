package utility;

import medium.ListNode;
import medium.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenlijie on 9/14/17.
 */
public class Utils {

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void printStringList(List<String> list) {
        for (String i : list) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void printNodes(ListNode node) {
        ListNode n = node;
        while (n != null) {
            System.out.print(n.val + "  ");
            n = n.next;
        }
        System.out.println();
    }

    public static TreeNode buildLeft(TreeNode node, int val) {
        TreeNode left = new TreeNode(val);
        node.left = left;
        return left;
    }
    public static TreeNode buildRight(TreeNode node, int val) {
        TreeNode right = new TreeNode(val);
        node.right = right;
        return right;
    }

    public static TreeNode buildTree(String str) {
        Queue<String> queue = new LinkedList<>();

        for (String s : str.split(",")) {
            queue.offer(s);
        }

        return buildTreeFromString(queue);
    }

    private static TreeNode buildTreeFromString(Queue<String> queue) {
        if (queue.isEmpty())
            return null;

        String x = queue.poll();

        if ("X".equals(x)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(x));
        node.left = buildTreeFromString(queue);
        node.right = buildTreeFromString(queue);

        return node;
    }
}
