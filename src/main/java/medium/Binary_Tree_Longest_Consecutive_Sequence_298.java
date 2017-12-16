package medium;

/**
 * Created by chenlijie on 11/7/17.
 */
public class Binary_Tree_Longest_Consecutive_Sequence_298 {

    static int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, 0, 0);
    }

    static int longestConsecutive(TreeNode node, int preVal, int path) {
        if (node == null) {
            return 0;
        }

        int currPath = node.val == preVal + 1 ? path + 1 : 1;

        int leftPath = longestConsecutive(node.left, node.val, currPath);
        int rightPath = longestConsecutive(node.right, node.val, currPath);

        return currPath > leftPath ? (currPath > rightPath ? currPath : rightPath) : (leftPath > rightPath ? leftPath : rightPath);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.right = node3;
        node3.right = node4;
        node3.left = node2;

        System.out.println(longestConsecutive(node1));
    }
}
