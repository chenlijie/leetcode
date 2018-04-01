package ebay;

import medium.TreeNode;
import utility.Utils;

import java.util.PriorityQueue;

public class FindingKthClosestElementOfBSTToV {


//    finding the K-th closest element of a BST to a value V
    static int kthClosestElement(TreeNode node, int k, int t) {
        PriorityQueue<TreeNode> q = new PriorityQueue<>((t1, t2) -> Math.abs(t2.val - t) - Math.abs(t1.val - t));
        dfs(node, k, t, q);
        return q.isEmpty() ? Integer.MIN_VALUE : q.poll().val;
    }

    static void dfs(TreeNode node, int k, int t, PriorityQueue<TreeNode> q) {
        if (node != null) {
            if (q.size() < k) {
                q.offer(node);
            } else if (Math.abs(node.val - t) < Math.abs(q.peek().val - t)) {
                q.poll();
                q.offer(node);
            }

            dfs(node.left, k, t, q);
            dfs(node.right, k, t, q);
        }
    }

    public static void main(String[] args) {
        TreeNode root = Utils.buildTree("7,4,1,X,X,6,5,X,15,12,X,X,19,18,X,X,20,X,X");
        System.out.println(kthClosestElement(root, 3, 8));
        System.out.println(kthClosestElement(root, 3, 1));
        System.out.println(kthClosestElement(root, 3, 30));


        System.out.println(binarySearch(new int[] {1,2,3,3,4}, 3));
        System.out.println(binarySearch(new int[] {1,2,3,3,4}, 1));
    }


    static int binarySearch(int[] nums, int x) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (x >= nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
}
