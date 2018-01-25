package facebook.fblist;

import medium.TreeNode;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoBSTToList {

    //两个BST，从小到大输出成一个list，讨论空间复杂度，最坏和最好的情况
    // Tree 1 size is m, Tree 2 size is n
    // worst scenario : all nodes only have left child, when do in order iteration we need save all them into stack
    // the space complexity is O (m + n), time complexity is O (m + n)
    // best scenario : all nodes only have right child, when do in order iteration we only push one node to stack then
    // immediate pop it
    List<Integer> toList(TreeNode node1, TreeNode node2) {
        List<Integer> list1 = inOrder(node1);
        List<Integer> list2 = inOrder(node2);

        int i1 = 0;
        int i2 = 0;
        int len1 = list1.size();
        int len2 = list2.size();

        List<Integer> ans = new ArrayList<>();
        while (i1 < len1 && i2 < len2) {
            if (list1.get(i1) < list2.get(i2)) {
                ans.add(list1.get(i1++));
            } else {
                ans.add(list2.get(i2++));
            }
        }

        while (i1 < len1) {
            ans.add(list1.get(i1++));
        }

        while (i2 < len2) {
            ans.add(list2.get(i2++));
        }

        return ans;
    }

    private List<Integer> inOrder(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            //visit
            node = stack.pop();
            ans.add(node.val);

            //get next
            node = node.right;
        }

        return ans;
    }

    public static void main(String[] args) {
//        TreeNode node1 = Utils.buildTree("10,4,1,X,X,8,X,X,15,X,X");
        TreeNode node1 = Utils.buildTree("15,10,8,4,1,X,X,X,X,X,X");
        TreeNode node2 = Utils.buildTree("9,5,2,X,X,X,14,11,X,X,X");


        TwoBSTToList t = new TwoBSTToList();
        System.out.println(t.toList(node1, node2));
    }
}
