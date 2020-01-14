package microsoft.onsite;

import medium.TreeNode;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;


//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
public class PreOrder {

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode cur = root;

        while (cur != null) {
            ans.add(cur.val);

            if (cur.left == null) {
                TreeNode next = cur.right;

                if (cur.right != next)
                    cur.right = null;

                cur = next;
            } else {
                TreeNode next = cur.left;

                while (next.right != null)
                    next = next.right;

                next.right = cur.right;
                cur = cur.left;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,2,X,X,3,X,4,X,X");
        preorderTraversal(node);

        System.out.println(node);
//        Utils.printInOrderTreeNode(node);
    }
}
