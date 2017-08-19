package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Remove_K_Digits_402 {

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        int i = 0;
        for (; i < num.length() && k > 0; i++) {

            while (!stack.isEmpty() && k >0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            if (num.charAt(i) != '0' || !stack.isEmpty()) {
                stack.push(num.charAt(i));
            }
        }

        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }

        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        if (i < num.length()) {
            builder.append(num.substring(i));
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(removeKdigits("1234567890", 9).equals("0"));
        System.out.println(removeKdigits("1107", 1).equals("107"));
        System.out.println(removeKdigits("1", 1).equals("0"));
        System.out.println(removeKdigits("21", 1).equals("1"));
        System.out.println(removeKdigits("213", 1).equals("13"));
        System.out.println(removeKdigits("2131", 2).equals("11"));
        System.out.println(removeKdigits("2012", 1).equals("12"));
        System.out.println(removeKdigits("21012", 2).equals("12"));
        System.out.println(removeKdigits("2000000", 2).equals("0"));
    }
}
