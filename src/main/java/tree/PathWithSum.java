package tree;

import medium.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlijie on 10/19/17.
 */
public class PathWithSum {

    int sumPath(int n, TreeNode root, List<Integer> sums) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        List<Integer> copy = new ArrayList<>(sums);
        for (int i = 0; i < copy.size(); i++) {
            copy.set(i, copy.get(i) + root.val);

            if (n == copy.get(i)) {
                count++;
            }
        }

        if (n == root.val) {
            count++;
        }
        copy.add(root.val);

        return count + sumPath(n, root.left, copy) + sumPath(n, root.right, copy);
    }

    int countPathsWithSum(TreeNode node, int target) {
        if (node == null) {
            return 0;
        }
        return countPathsWithSumFromNode(node, target, 0) + countPathsWithSum(node.left, target) + countPathsWithSum(node.right, target);
    }

    int countPathsWithSumFromNode(TreeNode node, int target, int currSum) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        currSum += node.val;

        if (currSum == target) {
            count++;
        }

        int countLeft = countPathsWithSumFromNode(node.left, target, currSum);
        int countRight = countPathsWithSumFromNode(node.right, target, currSum);

        return count + countLeft + countRight;
    }

    int countPath(TreeNode node, int target, int currSum, Map<Integer, Integer> sums) {
        if (node == null) {
            return 0;
        }

        currSum += node.val;

        int count = sums.getOrDefault(currSum - target, 0);
        sums.put(currSum, sums.getOrDefault(currSum, 0) + 1);

        int countLeftSub = countPath(node.left, target, currSum, sums);
        int countRightSub = countPath(node.right, target, currSum, sums);

        sums.put(currSum, sums.get(currSum) - 1);

        return count + countLeftSub + countRightSub;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-1);
        TreeNode node8 = new TreeNode(1);

        node1.left = node2;
        node1.right = node6;

        node2.left = node3;
        node2.right = node4;

        node4.left = node5;

        node6.left = node7;
        node6.right = node8;

        System.out.println(new PathWithSum().sumPath(4, node1, new ArrayList<>()));
        System.out.println(new PathWithSum().countPathsWithSum(node1, 4));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        System.out.println(new PathWithSum().countPath(node1, 4, 0, map));
    }
}
