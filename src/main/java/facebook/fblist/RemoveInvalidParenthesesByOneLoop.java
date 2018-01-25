package facebook.fblist;

import java.util.Stack;

public class RemoveInvalidParenthesesByOneLoop {

    static String remove(String s) {

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int len = s.length();

        while (i < len) {
            while (i < len && s.charAt(i) != '(') {
                if (s.charAt(i) != ')') {
                    ans.append(s.charAt(i));
                }
                i++;
            }

            int j = i + 1;
            while (j < len && s.charAt(j) != ')') {
                j--;
            }

        }

        return ans.toString();
    }

    static String remove2(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder builder = new StringBuilder(s);
        while (!stack.isEmpty()) {
            builder.deleteCharAt(stack.pop());
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(remove("ab()()cd"));
        System.out.println(remove2(")a)b(c)d)e))()()"));
    }
}
