package medium;

/**
 * Created by chenlijie on 1/7/18.
 */
public class Ternary_Expression_Parser_439 {

    public String parseTernary(String expression) {

        while (expression.indexOf('?') != -1) {
            char t = expression.charAt(0);
            int end = expression.lastIndexOf(':');

            if (t == 'T') {
                expression = expression.substring(2, findNextColon(expression));
            } else {
                expression = expression.substring(end + 1);
            }
        }

        return expression;
    }

    int findNextColon(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                cnt++;
            } else if (c == ':') {
                if (--cnt == 0)
                    return i;
            }
        }
        return -1;
    }
}
