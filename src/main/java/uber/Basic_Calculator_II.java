package uber;

import java.util.Stack;

public class Basic_Calculator_II {

    static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + s.charAt(i) - '0';
            } else if (s.charAt(i) != ' ') {
                switch(op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                op = s.charAt(i);
                num = 0;
            }
        }

        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();

        System.out.println(sum);
        return sum;

    }

    public static void main(String[] args) {
        calculate("32");
    }
}
