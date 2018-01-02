package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 12/21/17.
 */
public class Basic_Calculator_II_227 {

    static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
        char op = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (c >= '0' && c <= '9') {
                num = num*10 + c - '0';
            } else {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }

        if (op == '+') {
            stack.push(num);
        } else if (op == '-') {
            stack.push(-num);
        } else if (op == '*') {
            stack.push(stack.pop() * num);
        } else if (op == '/') {
            stack.push(stack.pop() / num);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*6"));
    }
}
