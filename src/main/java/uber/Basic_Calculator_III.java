package uber;

import java.util.Stack;

public class Basic_Calculator_III {

    static int calculate(String s) {

        int curRes = 0;
        int res = 0;
        char op = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int cnt = 1;
                int j = i + 1;
                for (i = j; i < s.length(); i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }

                num = calculate(s.substring(j, i));
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch(op) {
                    case '+':
                        curRes += num;break;
                    case '-':
                        curRes -= num;break;
                    case '*':
                        curRes *= num;break;
                    case '/':
                        curRes /= num;break;
                }

                if (c == '-' || c == '+' || i == s.length() - 1) {
                    res += curRes;
                    curRes = 0;
                }
                num = 0;
                op = c;
            }
        }

        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {
        calculate("2*(5+5*2)/3");
    }
}
