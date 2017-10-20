package tree;

import java.util.Random;

/**
 * Created by chenlijie on 10/19/17.
 */
public class Tree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public void insertInOrder(int d) {
            if (d <= data) {
                if (left == null) {
                    left = new TreeNode(d);
                } else {
                    left. insertInOrder( d);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(d);
                } else {
                    right.insertInOrder(d);
                }
            }
            size++;
        }

        public TreeNode getIthNode(int i) {
            int leftSize = left== null? 0: left.size();
            if (i < leftSize) {
                return left.getIthNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                return right.getIthNode(i - (leftSize + 1));
            }
        }

        public int size() {
            return size;
        }
    }

    TreeNode root= null;

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode() {
        if (root == null) return null;

        Random random = new Random();
        int i= random.nextInt(size());
        System.out.println("i = " + i);
        return root.getIthNode(i);
    }

    public void insertinOrder(int value) {
        if (root== null) {
            root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertinOrder(5);
        tree.insertinOrder(3);
        tree.insertinOrder(10);
//        tree.insertinOrder(2);

        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);

    }
}
