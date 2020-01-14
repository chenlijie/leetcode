package amazon.onsite;

import medium.TreeNode;
import utility.Utils;

import java.util.HashSet;
import java.util.Set;

public class EqualTree {

    static boolean checkEqualTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        int sum = dfs(root.left, set) + dfs(root.right, set);

        return sum % 2 == 0 && set.contains(sum/2);
    }

    static int dfs(TreeNode node, Set<Integer> set) {
        if (node == null) return 0;

        int sum = dfs(node.left, set) + dfs(node.right, set) + node.val;
        set.add(sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("5,10,X,X,-10,-2,X,X,-3,X,X");
        System.out.println(checkEqualTree(node));
    }
}
