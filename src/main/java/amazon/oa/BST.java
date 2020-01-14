package amazon.oa;


/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=276519&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D3
 * @author Zhiyuan
 *
 */
public class BST {

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    private void insert(int val) {

        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {

                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return;
                }
                else {
                    cur = cur.right;
                }
            }
            else if (cur.val > val) {

                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return;
                }
                else {
                    cur = cur.left;
                }
            }
            // equal
            else {
                return;
            }
        }
    }

    //Main Entrance;
    public int bstDistance( int[] values, int n, int node1, int node2 ){
        if( values == null || values.length == 0 || n != values.length ) {
            return -1;
        }

        for( int i : values ) {
            insert(i);
        }

        int l1 = pathLength( root, node1 );
        int l2 = pathLength( root, node2 );
        if( l1 == -1 || l2 == -1 ) {
            return -1;
        }
        int lca = findLCA( root, node1, node2 ).val;
        int l3 = pathLength( root, lca );

        return (l1+l2) - 2*l3;
    }

    private TreeNode findLCA( TreeNode root, int node1, int node2 ) {
        while( (root.val - node1 ) *( root.val - node2 ) > 0 ) {
            root = node1 < node2 ? root.left : root.right;
        }
        return root;
    }

    private int pathLength( TreeNode root, int val ) {
        boolean find = false;
        int length = -1;
        while( root != null ) {
            if( root.val == val ) {
                length++;
                find = true;
                break;
            }
            root = root.val < val ? root.right : root.left;
            length++;
        }

        return find ? length : -1;
    }


    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = new int[] {5,6,3,1,2,4};


        System.out.println(bst.bstDistance(nums, nums.length, 2, 1));
    }
}

