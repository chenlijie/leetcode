package medium;

public class Smallest_String_Starting_From_Leaf_988 {

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root);
    }

    String dfs(TreeNode node) {
        if (node == null) return null;

        if (node.left == null && node.right == null) {
            return String.valueOf((char) (node.val + 'a'));
        }

        String left = dfs(node.left);
        String right = dfs(node.right);

        if (left == null) {
            return right + (char) (node.val + 'a');
        } else if (right == null) {
            return left + (char) (node.val + 'a');
        } else if (left.length() < right.length()){
            return left + (char) (node.val + 'a');
        } else if (left.length() > right.length()){
            return right + (char) (node.val + 'a');
        } else {
            return left.compareTo(right) < 0 ? left  + (char) (node.val + 'a') : right + (char) (node.val + 'a');
        }
    }

    public static void main(String[] args) {
        Smallest_String_Starting_From_Leaf_988 s = new Smallest_String_Starting_From_Leaf_988();
        TreeNode root = new TreeNode(1);
        System.out.println(s.smallestFromLeaf(root));

        char c = (char) 98;

        System.out.println(c);
    }
}


