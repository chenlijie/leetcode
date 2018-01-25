package facebook.fblist;

import java.util.Stack;

public class SumExpression {

    //字符串含+，*和数字，return int结果

    static int sum(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int i = 0;
        char operand = '+';
        Stack<Integer> stack = new Stack<>();

        while (i < len) {
            char c = s.charAt(i);

            if (c == '+' || c == '*') {
                operand = c;
                i++;
            } else {
                int j = i + 1;
                while (j < len && s.charAt(j) != '+' && s.charAt(j) != '*') {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));

                if (operand == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(num);
                }
                i = j;
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum("3+4*5+6*5*10+5"));
    }
}
