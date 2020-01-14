package amazon.oa;

import medium.TreeNode;

public class BuildBST {


    static TreeNode build(int[] nums) {
        if (nums.length == 0)
            return null;

        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            build(root, nums[i]);
        }

        return root;
    }

    private static TreeNode build(TreeNode node, int num) {
        if (node == null)
            return new TreeNode(num);

        if (num > node.val)
            node.right = build(node.right, num);
        else
            node.left = build(node.left, num);

        return node;
    }


    static TreeNode LCA(TreeNode node, int n1, int n2) {
        if (node == null || node.val == n1 || node.val == n2)
            return node;

        if (node.val > n1 && node.val > n2) {
            return LCA(node.left, n1, n2);
        } else if (node.val < n1 && node.val < n2) {
            return LCA(node.right, n1, n2);
        } else {
            return node;
        }
    }

    static int getDistance_2(TreeNode node, int n1, int n2) {
        int h1 = findLevel(node, n1);
        if (h1 == -1)
            return -1;

        int h2 = findLevel(node, n2);
        if (h2 == -1)
            return -1;

        int h3 = findLevel(node, LCA(node, n1, n2).val);

        int h = h1 + h2 - 2 * h3;
        return h;
    }

    static int findLevel(TreeNode node, int val) {
        if (node == null)
            return -1;

        if (val == node.val) {
            return 1;
        } else if (val > node.val) {
            int level = findLevel(node.right, val);
            return level == -1 ? -1 : level + 1;
        } else {
            int level = findLevel(node.left, val);
            return level == -1 ? -1 : level + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode node = build(new int[] {5,6,3,1,2,4});

//        System.out.println(getDistance(node, 3, 5) == 1);
//        System.out.println(getDistance(node, 4, 5) == 2);
//        System.out.println(getDistance(node, 2, 6));
//        System.out.println(getDistance(node, 4, 1));
//        System.out.println(getDistance(node, 1, 3));


//        System.out.println(findLevel(node, 6));
//        System.out.println(findLevel(node, 2));
//        System.out.println(findLevel(node, 4));
//        System.out.println(findLevel(node, 61));

        System.out.println(getDistance_2(node, 5, 5) == 0);
        System.out.println(getDistance_2(node, 2, 4) == 3);
        System.out.println(getDistance_2(node, 6, 2) == 4);
        System.out.println(getDistance_2(node, 2, 2) == 0);
        System.out.println(getDistance_2(node, 3, 4) == 1);
    }
}
