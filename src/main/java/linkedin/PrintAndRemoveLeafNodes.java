package linkedin;

import medium.TreeNode;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/12/17.
 */
public class PrintAndRemoveLeafNodes {

    static void printAndRemove(TreeNode node) {
        List<List<Integer>> res = new ArrayList<>();
        helper(node, res);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    static int helper(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return -1;

        if (node.left == null && node.right == null) {
            if (res.size() == 0) {
                res.add(new ArrayList<>());
            }
            res.get(0).add(node.val);
            return 0;
        }

        int left = helper(node.left, res);
        int right = helper(node.right, res);

        node.left = null;
        node.right = null;

        int d = Math.max(left, right) + 1;
        if (res.size() == d) {
            res.add(new ArrayList<>());
        }
        res.get(d).add(node.val);

        return d;
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,2,4,X,X,3,X,X");
        printAndRemove(node);
        System.out.println(node.left);
        System.out.println(node.right);
    }
}
