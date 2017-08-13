package medium;

/**
 * Created by chenlijie on 8/12/17.
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, 0, preorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int index, int istart, int iend) {


        TreeNode node = new TreeNode(preorder[index]);

        int k = istart;
        for (; k <= iend; k++) {
            if (inorder[k] == preorder[index]) {
                break;
            }
        }

        if (k-1 >= istart) {
            node.left = build(preorder, inorder, index+1, istart, k-1);
        }

        if (k+1 <= iend) {
            node.right = build(preorder, inorder, index+k+1-istart, k+1, iend);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105().buildTree(new int[]{1,2,4,5,3,6,7}, new int[]{4,2,5,1,6,3,7});
        System.out.println(node);
    }
}
