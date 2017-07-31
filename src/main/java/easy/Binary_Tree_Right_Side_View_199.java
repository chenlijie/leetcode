package easy;

import medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenlijie on 7/24/17.
 */
public class Binary_Tree_Right_Side_View_199 {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                if (i == size-1) {
                    res.add(node.val);
                }
            }
        }

        return res;
    }
}
