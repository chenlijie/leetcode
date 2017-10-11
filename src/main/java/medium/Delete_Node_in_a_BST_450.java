package medium;

/**
 * Created by chenlijie on 8/12/17.
 */
public class Delete_Node_in_a_BST_450 {


    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int min = minVal(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }

        return root;
    }

    public int minVal(TreeNode node) {
        int min = node.val;

        while (node.left != null) {
            node = node.left;
            min = Math.min(node.val, min);
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(4);
        left.left = left1;
        left.right = right1;

//        TreeNode left2 = new TreeNode(9);
        TreeNode right2 = new TreeNode(7);
//        right.left = left2;
        right.right = right2;
//
//
//        TreeNode left3 = new TreeNode(19);
//        TreeNode right3 = new TreeNode(25);
//        right2.left = left3;
//        right2.right = right3;


        new Delete_Node_in_a_BST_450().deleteNode(root, 5);
    }
}
