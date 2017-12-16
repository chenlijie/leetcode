package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 10/23/17.
 */
public class Reverse_Words_in_a_String_151 {

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ' ' && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }

            if (s.charAt(i) == ' ') {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                stack2.push(s.charAt(i));
            } else {
                stack1.push(s.charAt(i));
            }
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        StringBuffer buffer = new StringBuffer("");
        while (!stack2.isEmpty()) {
            buffer.append(stack2.pop());
        }

        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("<" + reverseWords(" a  b   c  ") + ">");
    }
}
