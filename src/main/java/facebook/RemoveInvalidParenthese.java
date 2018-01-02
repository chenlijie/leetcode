package facebook;

import java.util.Stack;

/**
 * Created by chenlijie on 12/18/17.
 */
public class RemoveInvalidParenthese {

    static String remove3(String s) {
        if (s == null)
            return null;

        int rmL = 0;
        char[] ans = new char[s.length()];
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rmL++;
                ans[len++] = c;
            } else if (c == ')'){
                if (rmL > 0) {
                    rmL--;
                    ans[len++] = c;
                }
            } else {
                ans[len++] = c;
            }
        }

        int start = rmL;
        for (int i = len-1, j = len - 1; i >= 0; i--) {
            if (ans[i] == '(' && rmL > 0) {
                rmL--;
            } else {
                ans[j--] = ans[i];
            }
        }

        return new String(ans, start, len-start);
    }

    static String remove2(String s) {
        if (s == null)
            return null;

        int rmL = 0;
        int rmR = 0;

        //to figure out how many left brace and right brace need to be removed
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rmL++;
            } else if (c == ')'){
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }

        //remove first rmR right brace
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && rmR > 0) {
                rmR--;
            } else {
                builder.append(c);
            }
        }

        s = builder.reverse().toString();

        //remove last rmL left brace
        builder.setLength(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' && rmL > 0) {
                rmL--;
            } else {
                builder.append(c);
            }
        }

        return builder.reverse().toString();
    }

    static String remove(String s) {
        if (s == null)
            return null;

        Stack<Character> stack = new Stack<>();
        int rmL = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rmL++;
                stack.push(c);
            } else if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        char[] ans = new char[stack.size() - rmL];
        int i = ans.length - 1;

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(' && rmL > 0) {
                rmL--;
            } else {
                ans[i--] = c;
            }
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(remove3("())(a(b"));
        System.out.println(remove("(()"));
        System.out.println(remove("(())"));
        System.out.println(remove("()))"));
        System.out.println(remove("))(("));
        System.out.println(remove("a(b(c)"));
        System.out.println(remove(")))))))))(((((((ab)"));
    }
}
