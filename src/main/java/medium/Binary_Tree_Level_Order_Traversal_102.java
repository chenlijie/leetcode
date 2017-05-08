package medium;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_102 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //BFS
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<Integer>();
            int size = queue.size();
            for (int i= 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);

                subList.add(temp.val);
            }
            list.add(subList);
        }

        return list;
    }


    //DFS

    public static void main(String[] args) {
        Binary_Tree_Level_Order_Traversal_102.TreeNode root = new Binary_Tree_Level_Order_Traversal_102.TreeNode(1);
        Binary_Tree_Level_Order_Traversal_102.TreeNode left = new Binary_Tree_Level_Order_Traversal_102.TreeNode(2);
        Binary_Tree_Level_Order_Traversal_102.TreeNode right = new Binary_Tree_Level_Order_Traversal_102.TreeNode(3);
        root.left = left;
        root.right = right;

        Binary_Tree_Level_Order_Traversal_102.TreeNode left2 = new Binary_Tree_Level_Order_Traversal_102.TreeNode(4);
        Binary_Tree_Level_Order_Traversal_102.TreeNode right2 = new Binary_Tree_Level_Order_Traversal_102.TreeNode(5);
        left.left = left2;
        left.right = right2;

        Binary_Tree_Level_Order_Traversal_102.TreeNode left3 = new Binary_Tree_Level_Order_Traversal_102.TreeNode(6);
        Binary_Tree_Level_Order_Traversal_102.TreeNode right3 = new Binary_Tree_Level_Order_Traversal_102.TreeNode(7);
        right.left = left3;
        right.right = right3;

        levelOrder(root);
    }

}
