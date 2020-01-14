package microsoft.onsite;

import medium.TreeNode;
import utility.Utils;

public class RecoverBST {

    public void recoverTree(TreeNode root) {
        TreeNode missPlacedNode1 = null;
        TreeNode missPlacedNode2 = null;

        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode lastVisitedNode = null;

        while (cur != null) {
            if (cur.left == null) {
                if (lastVisitedNode != null && lastVisitedNode.val > cur.val) {
                    if (missPlacedNode1 == null) {
                        missPlacedNode1 = lastVisitedNode;
                        missPlacedNode2 = cur;
                    } else {
                        missPlacedNode2 = cur;
                        break;
                    }
                }
                lastVisitedNode = cur;
                cur = cur.right;
            } else {
                pre = cur.left;

                while (pre.right != null && pre.right != cur)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    if (lastVisitedNode != null && lastVisitedNode.val > cur.val) {
                        if (missPlacedNode1 == null) {
                            missPlacedNode1 = lastVisitedNode;
                            missPlacedNode2 = cur;
                        } else {
                            missPlacedNode2 = cur;
                            pre.right = null;
                            break;
                        }
                    }
                    lastVisitedNode = cur;
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        int val = missPlacedNode1.val;
        missPlacedNode1.val = missPlacedNode2.val;
        missPlacedNode2.val = val;
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("3,X,1,2,X,X,X");
        RecoverBST r = new RecoverBST();
        r.recoverTree(node);
    }
}
