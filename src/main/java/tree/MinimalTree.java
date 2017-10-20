package tree;

import medium.TreeNode;
import utility.Utils;

import java.util.*;

/**
 * Created by chenlijie on 10/17/17.
 */
public class MinimalTree {

    public static TreeNode build(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private static TreeNode build(int[] nums, int start, int end) {
        if (end <= start) {
            return null;
        }

        int mi = (start + end) >> 1;
        TreeNode node = new TreeNode(nums[mi]);

        node.left = build(nums, start, mi);
        node.right = build(nums, mi+1, end);

        return node;
    }

    public static List createLinkedList(TreeNode root) {
        List<LinkedList<TreeNode>> list = new ArrayList<>();
        buildLinkedList(root, list, 0);
        return list;
    }

    private static void buildLinkedList(TreeNode root, List<LinkedList<TreeNode>> list, int level) {
        if (root != null) {
            if (list.size() == level) {
                LinkedList<TreeNode> linkedList = new LinkedList<>();
                linkedList.add(root);
                list.add(linkedList);
            } else {
                list.get(level).add(root);
            }

            buildLinkedList(root.left, list, level + 1);
            buildLinkedList(root.right, list, level + 1);
        }
    }

    public static boolean checkBalanced(TreeNode node) {
        return checkHeight(node) == Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean validateBST(TreeNode root) {

        Stack<TreeNode> queue = new Stack<>();
        TreeNode pre = null;

        while (root != null || !queue.isEmpty()) {

            while (root != null) {
                queue.push(root);
                root = root.left;
            }

            root = queue.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
        }

        return true;
    }

    public static boolean validateBST2(TreeNode root) {
        return validateBSTHelper(root, null, null);
    }

    public static boolean validateBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        if (!validateBSTHelper(root.left, min, root.val)) {
            return false;
        }

        if (!validateBSTHelper(root.right, root.val, max)) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        TreeNode root = build(new int[] {Integer.MIN_VALUE, 3, 4, 5, 6, Integer.MAX_VALUE});
        System.out.println(root);

//        root.val = 2;
        System.out.println(validateBST2(root));
    }
}
