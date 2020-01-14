package microsoft.onsite;

import medium.TreeNode;
import utility.Utils;

import java.util.*;

public class PathFromOneNodeToAnother {

//    给定一个二叉树，和一个节点A和一个节点B,找到从A到B的一条路径，各种边界情况

    static List<TreeNode> path(TreeNode root, TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null || root == null) {
            return new ArrayList<>();
        }

        if (node1 == node2) {
            List<TreeNode> ans = Arrays.asList(node1);
            System.out.println(ans);
            return ans;
        }

        Deque<TreeNode> q1 = new LinkedList<>();
        find(root, node1, q1);
        Deque<TreeNode> q2 = new LinkedList<>();
        find(root, node2, q2);

        if (q1.size() < q2.size()) {
            Deque<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        List<TreeNode> ans = new ArrayList<>();
        while (!q1.isEmpty()) {
            ans.add(q1.pollLast());
        }

        TreeNode corner = null;
        while (ans.get(ans.size() - 1) == q2.peekFirst()) {
            corner = q2.pollFirst();
            ans.remove(ans.size() - 1);
        }

        ans.add(corner);
        while (!q2.isEmpty()) {
            ans.add(q2.pollFirst());
        }
        System.out.println(ans);
        return ans;
    }

    static boolean find(TreeNode root, TreeNode node, Deque<TreeNode> q) {
        if (root == null)
            return false;

        q.add(root);

        if (root == node)
            return true;

        if (find(root.left, node, q))
            return true;

        if (find(root.right, node, q))
            return true;

        q.pollLast();
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,2,3,4,X,X,5,X,6,X,X,X,7,8,X,X,9,10,X,X,X");
        TreeNode node1 = Utils.findTreeNode(node, 8);
        TreeNode node2 = Utils.findTreeNode(node, 10);
        path(node, node1, node2);
    }


}
