package amazon.onsite;

import java.util.Stack;


public class ExpressionTree {

    
    public class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
          this.symbol = symbol;
          this.left = this.right = null;
        }
    }

    class TreeNode {
        int val;
        ExpressionTreeNode eNode;
        public TreeNode(int val, String s) {
            this.val = val;
            eNode = new ExpressionTreeNode(s);
        }
    }

    public ExpressionTreeNode build(String[] expression) {
        if (expression == null || expression.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int base = 0;
        int val = 0;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if (expression[i].equals(")")) {
                base -= 10;
                continue;
            }
            val = getWeight(base, expression[i]);
            TreeNode node = new TreeNode(val, expression[i]);
            if (!stack.isEmpty() && node.val <= stack.peek().val) {
                node.eNode.left = stack.pop().eNode;
            }
            if (!stack.isEmpty()) {
                stack.peek().eNode.right = node.eNode;
            }
            stack.push(node);
        }
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode rst = stack.pop();
        while (!stack.isEmpty()) {
            rst = stack.pop();
        }

        print(rst.eNode);
        System.out.println();
        return rst.eNode;
    }
    //Calculate weight for characters
    public int getWeight(int base, String s) {
        if (s.equals("+") || s.equals("-")) {
            return base + 1;
        }
        if (s.equals("*") || s.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        ExpressionTree express = new ExpressionTree();
        express.build(new String[] {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"});
        express.build(new String[] { "(","(","15","/","(","7","−","(","1","+"," 1",")",")",")"," *"," 3",")","−","(","2","+","(","1","+","1",")",")"});
    }

    void print(ExpressionTreeNode e) {
        if (e != null) {
            print(e.left);
            print(e.right);
            System.out.print("\"" + e.symbol + "\",");
        }
    }
}
