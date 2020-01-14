package microsoft.onsite;

import medium.TreeNode;
import utility.Utils;

public class BSTToDoublyLinkedList {

    static TreeNode pre;
    static TreeNode head;

    static void convert(TreeNode node) {
        if (node == null)
            return;

        convert(node.left);
        if (head == null) {
            head = node;
        } else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        convert(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = Utils.buildTree("1,2,3,X,X,4,X,X,5,6,X,X,7,X,X");
        convert(node);


        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.right;
        }
    }
}
