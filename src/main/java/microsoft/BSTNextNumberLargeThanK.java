package microsoft;

import medium.TreeNode;
import utility.Utils;

public class BSTNextNumberLargeThanK {

//    BST 找比target 大的最小的数

    static int find(TreeNode node, int k) {
        return find(node, k, Integer.MAX_VALUE);
    }

    static int find(TreeNode node, int k, Integer num) {
        if (node == null)
            return num;

        if (node.val > k) {
            if (node.val < num)
                num = node.val;

            return find(node.left, k, num);
        } else {
            return find(node.right, k, num);
        }
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("9,5,1,X,X,8,X,X,20,15,X,X,26,X,X");
        System.out.println(find(node, -1));
        System.out.println(find(node, 26));
        System.out.println(find(node, 6));
        System.out.println(find(node, 16));
        System.out.println(find(node, 14));
    }
}
