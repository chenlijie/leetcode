package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlijie on 8/13/17.
 */
public class Most_Frequent_Subtree_Sum_508 {

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> sums = new ArrayList<>();

        Map<Integer, Integer> counts = new HashMap<>();
        int[] max = new int[1];
        treeSumRec(root, counts, max);

        for (int num : counts.keySet()) {
            if (counts.get(num) == max[0]) {
                sums.add(num);
            }
        }

        int[] result = new int[sums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sums.get(i);
        }

        return result;
    }

    private int treeSumRec(TreeNode node, Map<Integer, Integer> counts, int[] max) {

        if (node == null) {
            return 0;
        }

        int val = node.val + treeSumRec(node.left, counts, max) + treeSumRec(node.right, counts, max);
        counts.putIfAbsent(val, 0);
        counts.put(val, counts.get(val)+1);
        max[0] = Math.max(max[0], counts.get(val));
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-3);

        root.left = left;
        root.right = right;

        for (int i : new Most_Frequent_Subtree_Sum_508().findFrequentTreeSum(root)) {
            System.out.print(i + "  ");
        }
    }
}
