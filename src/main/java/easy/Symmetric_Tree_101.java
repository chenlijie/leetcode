package easy;

import medium.TreeNode;
import utility.Utils;

import java.util.*;

public class Symmetric_Tree_101 {

    static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        if (root.left == null || root.right == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if (p.val != q.val)
                return false;

            if (p.left == null) {
                if (q.right != null)
                    return false;
            } else {
                if (q.right == null)
                    return false;
                queue.offer(p.left);
                queue.offer(q.right);
            }

            if (p.right == null) {
                if (q.left != null)
                    return false;
            } else {
                if (q.left == null)
                    return false;
                queue.offer(p.right);
                queue.offer(q.left);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode root = Utils.buildTree("1,2,2,4,3,3,4");

        System.out.println(isSymmetric(root));

    }
}
