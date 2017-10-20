package tree;

import java.util.Random;

/**
 * Created by chenlijie on 10/18/17.
 */
public class RandomNode {

    private static class TreeNode {
        int val;
        int leftCount;
        int rightCount;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            leftCount = 1;
            rightCount = 0;
        }
    }

    int num = 0;
    TreeNode root;
    boolean success;

    void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            insert(root, val);
        }
        num++;
    }

    TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (node.val == val) {
            throw new NullPointerException();
        }

        if (val < node.val) {
            node.leftCount++;
            node.left = insert(node.left, val);
        } else {
            node.rightCount++;
            node.right = insert(node.right, val);
        }

        return node;
    }

    TreeNode find(int val) {
        return find(root, val);
    }

    TreeNode find(TreeNode node, int val) {
        if (node == null) {
            return null;
        } else if (val == node.val) {
            return node;
        } else if (val < node.val) {
            return find(node.left, val);
        } else {
            return find(node.right, val);
        }
    }

    void delete(int val) {
        success = false;
        delete(root, val);
        if (success) {
            num--;
        }
    }

    TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (val == node.val) {
            success = true;
            if (node.left != null && node.right != null) {
                TreeNode leftMost = findLeftMost(node.right);
                node.val = leftMost.val;
                node.right = delete(node.right, leftMost.val);
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        } else if (val < node.val) {
            node.left = delete(node.left, val);
            if (success) {
                node.leftCount--;
            }
        } else {
            node.right = delete(node.right, val);
            node.rightCount--;
        }

        return node;
    }

    TreeNode findLeftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    TreeNode getRandom() {
        Random random = new Random();
        int rank = random.nextInt(num) + 1;
        System.out.println("rank = " + rank);
        return findTreeNodeByRank(root, rank);
    }

    TreeNode findTreeNodeByRank(TreeNode node, int rank) {
        if (node.leftCount == rank) {
            return node;
        } else if (rank < node.leftCount) {
            return findTreeNodeByRank(node.left, rank);
        } else {
            return findTreeNodeByRank(node.right, rank-node.leftCount);
        }
    }
    public static void main(String[] args) {
        RandomNode randomNode = new RandomNode();

        randomNode.insert(5);
        randomNode.insert(3);
        randomNode.insert(1);
        randomNode.insert(4);
        randomNode.insert(2);

        randomNode.insert(10);
        randomNode.insert(8);
        randomNode.insert(7);
        randomNode.insert(9);
        randomNode.insert(12);

//        System.out.println(randomNode.find(4).val);
//        System.out.println(randomNode.find(8).val);
//        System.out.println(randomNode.find(12).val);
//        System.out.println(randomNode.find(15));
//        System.out.println(randomNode.find(6));

        System.out.println(randomNode.getRandom().val);
        System.out.println(randomNode.getRandom().val);
        System.out.println(randomNode.getRandom().val);
        System.out.println(randomNode.getRandom().val);

        randomNode.delete(1);
        randomNode.delete(5);

        System.out.println(randomNode.root);

        System.out.println(randomNode.getRandom().val);
        System.out.println(randomNode.getRandom().val);
        System.out.println(randomNode.getRandom().val);
        System.out.println(randomNode.getRandom().val);
    }
}
