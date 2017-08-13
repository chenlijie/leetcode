package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chenlijie on 8/13/17.
 */
public class Find_Bottom_Left_Tree_Value_513 {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int mostLeft = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    mostLeft = node.val;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return mostLeft;
    }

}
