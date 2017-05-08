package easy;

import java.util.Stack;

/**
 * Created by chenlijie on 4/11/17.
 */
public class Valid_Parentheses_20 {


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid_2(String s) {
        if (s.length()%2 == 1)
            return false;

        int len = s.length();
        char[] chars = s.toCharArray();
        char[] array = new char[len/2];

        int k = -1;
        for (int i = 0; i < len; i++) {
            if (k >= 0 && ((array[k] == '(' && chars[i] == ')') || (array[k] == '[' && chars[i] == ']') || (array[k] == '{' && chars[i] == '}'))) {
                k --;
            } else {
                if (++k >= len/2) {
                    return false;
                }
                array[k] = chars[i];
            }
        }

        if (k == -1)
            return true;
        else
            return false;
    }

}
