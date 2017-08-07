package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Find_Largest_Value_in_Each_Tree_Row_515 {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> maxList = new ArrayList<>();
        if (root == null) {
            return maxList;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (queue.size() != 0) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            maxList.add(max);
        }

        return maxList;
    }
}
