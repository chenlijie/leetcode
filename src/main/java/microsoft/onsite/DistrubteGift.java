package microsoft.onsite;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import medium.TreeNode;
import utility.Utils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistrubteGift {


    static void giveGift(TreeNode root, int n) {
        List<TreeNode> nodes = new ArrayList<>();

        boolean[][] canGive = new boolean[n][n];
        for (boolean[] b : canGive)
            Arrays.fill(b, true);

        helper(root, null, canGive, nodes);
        Collections.sort(nodes, (n1, n2) -> n1.val - n2.val);

        List<String> message = new ArrayList<>();
        give(root, nodes, canGive, message);

        System.out.println(message);
    }

    static boolean give(TreeNode node, List<TreeNode> nodes, boolean[][] canGive, List<String> message) {
        if (message.size() == nodes.size())
            return true;

        int idx = node.val;

        for (int i = 0; i < canGive.length; i++) {
            if (canGive[idx][i]) {
                canGive[idx][i] = false;
                message.add(idx + " gives gift to " + i);

                if (give(nodes.get(i), nodes, canGive, message)) {
                    return true;
                } else {
                    message.remove(message.size() - 1);
                }

                canGive[idx][i] = true;
            }
        }

        return false;
    }


    static void helper(TreeNode node, TreeNode parent, boolean[][] canGive, List<TreeNode> nodes) {
        if (node == null)
            return;

        int idx = node.val;
        canGive[idx][idx] = false;
        nodes.add(node);


        if (parent != null) {
            canGive[idx][parent.val] = false;

            if (parent.left != null)
                canGive[idx][parent.left.val] = false;

            if (parent.right != null)
                canGive[idx][parent.right.val] = false;
        }

        if (node.left != null) {
            canGive[idx][node.left.val] = false;
            helper(node.left, node, canGive, nodes);
        }

        if (node.right != null) {
            canGive[idx][node.right.val] = false;
            helper(node.right, node, canGive, nodes);
        }
    }

    public static void main(String[] args) {
        TreeNode root = Utils.buildTree("0,1,2,X,X,5,X,X,3,4,X,X,6,X,X");
        giveGift(root, 7);

        System.out.println(Instant.now());
        int j = 0;
        for (int i = 0; i < 100000; i++) {
            j++;
        }

        System.out.println(Instant.now());
    }
}
