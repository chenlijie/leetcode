package zillow;

import java.util.Stack;

public class ReverseWord {

    public String reverseWords(String s) {
        String[] str = s.split(" ");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (!"".equals(str[i]))
                stack.push(str[i]);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }

        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("".split(" ").length);
    }
}
