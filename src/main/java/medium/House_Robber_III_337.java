package medium;

import java.util.HashMap;
import java.util.Map;

public class House_Robber_III_337 {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static int rob2(TreeNode root) {

        if (root == null) return 0;

        int val = 0;

        if (root.left != null)
            val += rob2(root.left.left) + rob2(root.left.right);


        if (root.right != null)
            val += rob2(root.right.left) + rob2(root.right.right);

        return Math.max(val + root.val, rob2(root.left) + rob2(root.right));
    }
    
    public static int rob3(TreeNode root) {
        return rob3(root, new HashMap<TreeNode, Integer>());
    }

    public static int rob3(TreeNode root, Map<TreeNode, Integer> map) {

        if (root == null) return 0;
        
        if (map.containsKey(root))
            return map.get(root);

        int val = 0;

        if (root.left != null)
            val += rob3(root.left.left, map) + rob3(root.left.right, map);


        if (root.right != null)
            val += rob3(root.right.left, map) + rob3(root.right.right, map);

        int max = Math.max(val + root.val, rob3(root.left, map) + rob3(root.right, map));
        map.put(root, max);

        return max;
    }

    public static int rob(TreeNode root) {
        return Math.max(robNode(root), notRobNode(root));
    }

    private static int robNode(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return node.val;

        return node.val + notRobNode(node.left) + notRobNode(node.right);
    }

    private static int notRobNode(TreeNode node) {
        if (node == null || node.left == null && node.right == null)
            return 0;
        return Math.max(robNode(node.left), notRobNode(node.left)) + Math.max(robNode(node.right), notRobNode(node.right));
    }

    public static void main(String[] args) {
        System.out.println(test1() == 3);
        System.out.println(test2() == 5);
        System.out.println(test3() == 8);
        System.out.println(test4() == 7);
        System.out.println(test5() == 3);
        System.out.println(test6() == 3);
    }

    static int test1() {
        House_Robber_III_337.TreeNode root = new House_Robber_III_337.TreeNode(3);
        House_Robber_III_337.TreeNode left = new House_Robber_III_337.TreeNode(1);
        House_Robber_III_337.TreeNode right = new House_Robber_III_337.TreeNode(1);
        root.left = left;
        root.right = right;
        return rob3(root);
    }

    static int test2() {
        House_Robber_III_337.TreeNode root = new House_Robber_III_337.TreeNode(3);
        House_Robber_III_337.TreeNode left = new House_Robber_III_337.TreeNode(4);
        House_Robber_III_337.TreeNode right = new House_Robber_III_337.TreeNode(1);
        root.left = left;
        root.right = right;
        return rob3(root);
    }

    static int test3() {
        House_Robber_III_337.TreeNode root = new House_Robber_III_337.TreeNode(3);
        House_Robber_III_337.TreeNode left1 = new House_Robber_III_337.TreeNode(1);
        House_Robber_III_337.TreeNode right1 = new House_Robber_III_337.TreeNode(4);
        root.left = left1;
        root.right = right1;

        House_Robber_III_337.TreeNode left2 = new House_Robber_III_337.TreeNode(2);
        House_Robber_III_337.TreeNode right2 = new House_Robber_III_337.TreeNode(2);
        left1.left = left2;
        left1.right = right2;

        return rob3(root);
    }

    static int test4() {
        House_Robber_III_337.TreeNode root = new House_Robber_III_337.TreeNode(3);
        House_Robber_III_337.TreeNode left1 = new House_Robber_III_337.TreeNode(1);
        House_Robber_III_337.TreeNode right1 = new House_Robber_III_337.TreeNode(1);
        root.left = left1;
        root.right = right1;

        House_Robber_III_337.TreeNode left2 = new House_Robber_III_337.TreeNode(2);
        House_Robber_III_337.TreeNode right2 = new House_Robber_III_337.TreeNode(2);
        left1.left = left2;
        left1.right = right2;

        return rob3(root);
    }

    static int test5() {
        House_Robber_III_337.TreeNode root = new House_Robber_III_337.TreeNode(3);
        House_Robber_III_337.TreeNode left = new House_Robber_III_337.TreeNode(1);
        root.left = left;
        return rob3(root);
    }

    static int test6() {
        House_Robber_III_337.TreeNode root = new House_Robber_III_337.TreeNode(1);
        House_Robber_III_337.TreeNode left = new House_Robber_III_337.TreeNode(3);
        root.left = left;
        return rob3(root);
    }
    
}
