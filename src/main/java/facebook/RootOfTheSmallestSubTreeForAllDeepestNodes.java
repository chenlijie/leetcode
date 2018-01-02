package facebook;

import java.util.*;

/**
 * Created by chenlijie on 12/25/17.
 */
public class RootOfTheSmallestSubTreeForAllDeepestNodes {

    /*
    1 + 2 + 4 + 8 + 16 + 32

     */

    private static class TreeNode {
        char value;
        List<TreeNode> childern;
        TreeNode parent;
    }

    TreeNode rootOfTheSmallestSubTreeForAllDeepestNodes(TreeNode node) {
        Set<TreeNode> nodes = new HashSet<>();
        findDeepestNodes(node, 0, nodes);

        while (nodes.size() > 1) {
            Set<TreeNode> temp = new HashSet<>();

            for (TreeNode n : nodes) {
                if (n.parent != null)
                    temp.add(n.parent);
            }
            nodes.clear();
            nodes = temp;
        }
        return nodes.isEmpty() ? null : nodes.iterator().next();
    }

    int max = 0;
    void findDeepestNodes(TreeNode node, int d, Set<TreeNode> set) {

        if (node.childern == null || node.childern.isEmpty()) {
            if (d > max) {
                set.clear();
                set.add(node);
                max = d;
            } else if (d == max) {
                set.add(node);
            }
        } else {
            for (TreeNode n : node.childern) {
                findDeepestNodes(n, d+1, set);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[10];
        for (char i = 'a'; i < 'a'+10; i++) {
            nodes[i-'a'] = new TreeNode();
            nodes[i-'a'].value = i;
        }
        List<TreeNode> list123 = new ArrayList<>();
        list123.add(nodes[1]);
        list123.add(nodes[2]);
        list123.add(nodes[3]);
        nodes[0].childern = list123;
        nodes[1].parent = nodes[0];
        nodes[2].parent = nodes[0];
        nodes[3].parent = nodes[0];

        List<TreeNode> list45 = new ArrayList<>();
        list45.add(nodes[4]);
        list45.add(nodes[5]);
        nodes[1].childern = list45;
        nodes[4].parent = nodes[1];
        nodes[5].parent = nodes[1];

        List<TreeNode> list6 = new ArrayList<>();
        list6.add(nodes[6]);
        nodes[3].childern = list6;
        nodes[6].parent = nodes[3];

        List<TreeNode> list7 = new ArrayList<>();
        list7.add(nodes[7]);
        nodes[4].childern = list7;
        nodes[7].parent = nodes[4];

        List<TreeNode> list89 = new ArrayList<>();
        list89.add(nodes[8]);
        list89.add(nodes[9]);
        nodes[5].childern = list89;
        nodes[8].parent = nodes[5];
        nodes[9].parent = nodes[5];

        RootOfTheSmallestSubTreeForAllDeepestNodes r = new RootOfTheSmallestSubTreeForAllDeepestNodes();
        System.out.println(r.rootOfTheSmallestSubTreeForAllDeepestNodes(nodes[0]).value);
    }
}
