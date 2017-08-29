package medium;

import java.util.Stack;


/**
 * Created by chenlijie on 8/18/17.
 */
public class Decode_String_394 {

    public static String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if ("]".equals(s.substring(i, i+1))) {

                StringBuilder builder = new StringBuilder("");

                while (!"[".equals(stack.peek())) {
                    builder.insert(0, stack.pop());
                }
                stack.pop();

                String copy = builder.toString();

                StringBuilder repeat = new StringBuilder("");
                while (!stack.isEmpty() && isANumber(stack.peek())) {
                    repeat.insert(0, stack.pop());
                }

                int len = Integer.valueOf(repeat.toString());
                for (int j = 1; j < len; j++) {
                    builder.append(copy);
                }

                stack.push(builder.toString());
            } else {
                stack.push(s.substring(i, i+1));
            }
        }

        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }

    private static boolean isANumber(String num) {
        if ("0".equals(num) || "1".equals(num) || "2".equals(num) || "3".equals(num) || "4".equals(num)
                || "5".equals(num) || "6".equals(num) || "7".equals(num) || "8".equals(num) || "9".equals(num)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
