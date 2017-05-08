package easy;

public class Sum_Of_Left_Leaves_404 {

//    public static int sumOfLeftLeaves(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) {
//            return 0;
//        }
//        return sum(root, true);
//    }

//    public static int sum(TreeNode root, boolean flag) {
//        if (root.left != null && root.right == null) {
//            return sum(root.left, true);
//        } else if (root.left == null && root.right != null) {
//            return sum(root.right, false);
//        } else if (root.left != null && root.right != null) {
//            return sum(root.left, true) + sum(root.right, false);
//        } else {
//            if (flag) {
//                return root.val;
//            } else {
//                return 0;
//            }
//        }
//    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    public static int sum(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (flag)
                return root.val;
            else
                return 0;
        }

        return sum(root.left, true) + sum(root.right, false);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
