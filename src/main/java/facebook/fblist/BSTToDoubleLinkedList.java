package facebook.fblist;


import medium.TreeNode;
import tree.Tree;
import utility.Utils;

import java.util.*;

public class BSTToDoubleLinkedList {

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node pre;

    void convert(TreeNode root) {
        if (root == null)
            return;

        convert(root.left);

        Node node = new Node(root.val);
        if (head == null) {
            head = node;
            pre = head;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }

        convert(root.right);
    }

    Node convert2(TreeNode node) {

        Node head = null;
        Node pre = null;
        Node tail = null;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (pre == null) {
                head = new Node(node.val);
                pre = head;
            } else {
                Node cur = new Node(node.val);
                pre.right = cur;
                cur.left = pre;
                pre = cur;
                tail = cur;
            }

            node = node.right;
        }

        head.left = tail;
        tail.right = head;

        return head;
    }


    public static void main(String[] args) {
        BSTToDoubleLinkedList b = new BSTToDoubleLinkedList();
        TreeNode root = Utils.buildTree("1,2,4,X,X,7,8,X,X,X,3,5,X,X,6,X,X");
//        TreeNode root = Utils.buildTree("1,2,4,X,X,7,8,X,X,X");
//        TreeNode root = Utils.buildTree("1,X,2,3,X,X,X");
//        TreeNode root = Utils.buildTree("1,X,2,X,X");
//          TreeNode root = Utils.buildTree("2,3,X,X,X");

//        Utils.printInOrderTreeNode(node);
        Node node = b.convert2(root);
        Node head = node;

        node = node.right;
        while (node != head) {
            System.out.print(node.val + ", ");
            node = node.right;
        }
        System.out.println();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        System.out.println(queue.peek());
    }

}