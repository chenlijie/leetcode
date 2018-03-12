package tweeter;

import java.util.Stack;

public class InfoMask {

    static String maskEmail(String email) {
        int idx = email.indexOf('@');
//        StringBuilder builder = new StringBuilder();
//        builder.append(email.charAt(0))
//                .append("*****")
//                .append(email.substring(idx - 1));
//        return builder.toString();

        return String.join("", email.substring(0, 1), "*****", email.substring(idx - 1));
    }

    static String maskPhone(String num) {
        int idx = num.length() - 5;

        Stack<Character> stack = new Stack<>();
        for (int i = idx, j = 0; i >= 0; i--) {
            char c = num.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c);
                j++;
                if (j % 3 == 0) {
                    stack.push('-');
                }
            } else if (c == '+') {
                if (stack.peek() == '-') {
                    stack.pop();
                }
                stack.push('+');
            }
        }

        if (stack.peek() == '-')
            stack.pop();

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.append('-').append(num.substring(idx + 1));

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskEmail("chenlijie139@gmail.com"));
        System.out.println(maskPhone("+1 (333)444-5678"));
        System.out.println(maskPhone("+91 (333) 444-5678"));
        System.out.println(maskPhone("+111(333)444-5678"));
        System.out.println(maskPhone("333 444 5678"));
        System.out.println(maskPhone("(333)4445678"));
        System.out.println(maskPhone("(333)444-5678"));
    }
}
