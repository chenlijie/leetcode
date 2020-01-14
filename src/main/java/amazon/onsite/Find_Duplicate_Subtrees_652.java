package amazon.onsite;

import medium.TreeNode;
import utility.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Duplicate_Subtrees_652 {


    static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, result, map);
        return result;
    }

    static String helper(TreeNode node, List<TreeNode> result, Map<String, Integer> dup) {
        if (node == null) {
            return "#";
        }

        String s = String.valueOf(node.val) + "," + helper(node.left, result, dup) + helper(node.right, result, dup);

        if (dup.getOrDefault(s, 0) == 1)
            result.add(node);

        dup.put(s, dup.getOrDefault(s, 0) + 1);

        return s;
    }

    static int t;
    static Map<String, Integer> trees;
    static Map<Integer, Integer> count;
    static List<TreeNode> ans;

    static List<TreeNode> findDuplicateSubtrees_2(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    static int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }

    public static void main(String[] args) {
//        TreeNode node = Utils.buildTree("1,2,4,X,X,X,3,2,4,X,X,X,4,X,X");
//        TreeNode node = Utils.buildTree("0,12,34,X,X,X,0,1,234,X,X,X,X");
//        TreeNode node = Utils.buildTree("1,2,3,X,X,4,X,X,2,3,X,X,4,5,X,X,X");
        TreeNode node = Utils.buildTree("1,2,X,X,3,X,X");
        List<TreeNode> nodes = findDuplicateSubtrees(node);

        for (TreeNode n : nodes) {
            System.out.println(n.val);
        }
    }
}
