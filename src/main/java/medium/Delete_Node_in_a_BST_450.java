package medium;

/**
 * Created by chenlijie on 8/12/17.
 */
public class Delete_Node_in_a_BST_450 {


    public static TreeNode deleteNode(TreeNode root, int key) {

        TreeNode node = root;
        TreeNode parent = root;
        int flag = 0;

        while (node != null) {

            if (key == node.val) {

                if (node.left == null && node.right == null) {
                    if (flag == -1) {
                        parent.left = null;
                    } else if (flag == 1) {
                        parent.right = null;
                    } else {
                        root = null;
                    }
                } else if (node.left != null && node.right != null) {

                    TreeNode temp = node.right;
                    TreeNode pre = node.right;
                    while (temp.left != null) {
                        pre = temp;
                        temp = temp.left;
                    }

                    node.val = temp.val;
                    if (pre == temp) {
                        node.right = pre.right;
                    } else {
                        pre.left = null;
                    }
                } else if (node.left != null) {
                    if (flag == 0) {
                        root = node.left;
                    } else if (flag == -1) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.right;
                    }

                } else {
                    if (flag == 0 ) {
                        root = node.right;
                    } else if(flag == -1) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                }
                break;

            } else if (key > node.val) {
                parent = node;
                node = node.right;
                flag = 1;
            } else {
                parent = node;
                node = node.left;
                flag = -1;
            }
        }

        return root;
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


        deleteNode(root, 5);
    }
}
