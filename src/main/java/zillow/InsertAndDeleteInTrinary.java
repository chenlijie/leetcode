package zillow;

public class InsertAndDeleteInTrinary {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode middle;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode insert(TreeNode node, int x) {
        if (node == null)
            return new TreeNode(x);

        if (x == node.val) {
            node.middle = new TreeNode(x);
        } else if (x > node.val) {
            node.right = insert(node.right, x);
        } else {
            node.left = insert(node.left, x);
        }
        return node;
    }

    static TreeNode delete(TreeNode node, int x) {
        if (node == null)
            return null;

        if (x == node.val) {
            if (node.middle != null) {
                node.middle = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                int val = findSmallest(node.right);
                node.val = val;
                node.right = delete(node.right, val);
            }

        } else if (x > node.val) {
            node.right = delete(node.right, x);
        } else {
            node.left = delete(node.left, x);
        }
        return node;
    }

    private static int findSmallest(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static void main(String[] args) {
        TreeNode node = null;
        int[] nums = new int[] {5,4,9,10,9,9};

        for (int i : nums) {
            node = insert(node, i);
        }

        delete(node, 5);

        System.out.println(node);
    }
}
