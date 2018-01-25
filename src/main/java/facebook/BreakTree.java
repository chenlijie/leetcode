package facebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreakTree {

    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206292&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    private class TreeNode {
        int val;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<TreeNode> breakTree(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, null, ans);
        return ans;
    }

    int dfs(TreeNode node, TreeNode parent, List<TreeNode> ans) {
        if (node.children == null || node.children.isEmpty())
            return 1;

        int cnt = 1;

        Iterator<TreeNode> it = node.children.iterator();
        while (it.hasNext()) {
            int n = dfs(it.next(), node, ans);
            cnt += n;
            if (n == 0) {
                it.remove();
            }
        }

        if (cnt % 2 == 0) {
            ans.add(node);
        }

        return cnt % 2;
    }

    void test() {
        TreeNode[] nodes = new TreeNode[11];

        for (int i = 1; i <= 10; i++) {
            nodes[i] = new TreeNode(i);

            if (i != 9 || i != 4) {
                nodes[i].children = new ArrayList<>();
            }
        }

        nodes[1].children.add(nodes[2]);
        nodes[1].children.add(nodes[3]);
        nodes[1].children.add(nodes[6]);

        nodes[3].children.add(nodes[4]);

        nodes[6].children.add(nodes[8]);

        nodes[8].children.add(nodes[9]);
        nodes[8].children.add(nodes[10]);

        nodes[2].children.add(nodes[5]);
        nodes[2].children.add(nodes[7]);

        BreakTree breakTree = new BreakTree();
        List<TreeNode> ans = breakTree.breakTree(nodes[1]);
        for (TreeNode node : ans) {
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        new BreakTree().test();
    }
}
