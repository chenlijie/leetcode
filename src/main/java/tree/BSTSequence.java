package tree;

import medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 10/18/17.
 */
public class BSTSequence {

    static List<List<Integer>> getSequences(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> all = new ArrayList<>();
        List<TreeNode> pool = new ArrayList<>();
        List<Integer> seqs = new ArrayList<>();

        pool.add(root);

        generateSeqs(all, pool, seqs);
        return all;
    }

    static void generateSeqs(List<List<Integer>> all, List<TreeNode> pool, List<Integer> seqs) {
        if (pool.isEmpty()) {
            all.add(new ArrayList(seqs));
            return;
        }

        int size = pool.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = pool.get(i);
            seqs.add(node.val);

            if (node.left != null) {
                pool.add(node.left);
            }

            if (node.right != null) {
                pool.add(node.right);
            }

            pool.remove(i);
            generateSeqs(all, pool, seqs);

            if (node.left != null) {
                pool.remove(pool.size()-1);
            }

            if (node.right != null) {
                pool.remove(pool.size()-1);
            }

            pool.add(i, node);
            seqs.remove(seqs.size()-1);
        }
    }

    static List<LinkedList<Integer>> weaveAll(TreeNode root) {
        if (root == null) {
            new ArrayList<>();
        }

        List<LinkedList<Integer>> result = new ArrayList<>();

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);

        List<LinkedList<Integer>> firstWeaveList = weaveAll(root.left);
        List<LinkedList<Integer>> secondWeaveList = weaveAll(root.right);

        for (LinkedList<Integer> first : firstWeaveList) {
            for (LinkedList<Integer> second : secondWeaveList) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(first, second, result, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                           List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        first.addFirst(headFirst);
        prefix.removeLast();

        int headSecond = second.removeFirst();
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        second.addFirst(headSecond);
        prefix.removeLast();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node3;
        node4.right = node7;

        node3.left = node1;
        node3.right = node2;

        node7.left = node5;
        node7.right = node6;

        getSequences(node4);

        LinkedList<Integer> first = new LinkedList<>();
        first.add(1);
        first.add(2);

        LinkedList<Integer> second = new LinkedList<>();
        second.add(3);
        second.add(4);

        List<LinkedList<Integer>> results = new ArrayList<>();
        LinkedList<Integer> prefix = new LinkedList<>();

        weaveLists(first, second, results, prefix);

        System.out.println(results);

    }
}
