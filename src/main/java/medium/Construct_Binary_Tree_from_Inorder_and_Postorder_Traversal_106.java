package medium;

/**
 * Created by chenlijie on 8/16/17.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return inorder.length == 0 ? null : build(new int[]{postorder.length-1}, 0, inorder.length-1, inorder, postorder);
    }

    private TreeNode build(int[] rootIndex, int inorderStart, int inorderEnd, int[] inorder, int[] postorder) {

        if (rootIndex[0] < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[rootIndex[0]]);

        int k = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == postorder[rootIndex[0]]) {
                k = i;
                break;
            }
        }

        if (k + 1 <= inorderEnd) {
            rootIndex[0]--;
            root.right = build(rootIndex, k + 1, inorderEnd, inorder, postorder);
        }

        if (inorderStart <= k - 1 ) {
            rootIndex[0]--;
            root.left = build(rootIndex, inorderStart, k - 1, inorder, postorder);
        }

        return root;
    }

    public static void main(String[] args) {
//        TreeNode node = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106().buildTree(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        TreeNode node = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106().buildTree(new int[]{2, 1}, new int[]{2, 1});
        System.out.println(node);
    }
}
