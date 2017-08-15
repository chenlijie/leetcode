package medium;

/**
 * Created by chenlijie on 8/13/17.
 */
public class Sum_Root_to_Leaf_Numbers_129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] total = new int[1];
        sum(root, 0, total);
        return total[0];
    }

    private void sum(TreeNode node, int previous, int [] total) {
        if (node.left == null && node.right == null) {
            total[0] += previous*10 + node.val;
        }

        if (node.left != null) {
            sum(node.left, previous*10 + node.val, total);
        }

        if (node.right != null) {
            sum(node.right, previous*10 + node.val, total);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;
        System.out.println(new Sum_Root_to_Leaf_Numbers_129().sumNumbers(root));
    }
}
