package hard;

import java.util.Stack;

/**
 * Created by chenlijie on 4/13/17.
 */
public class Longest_Valid_Parentheses_32 {

    public static int longestValidParentheses(String s) {

        char[] c = s.toCharArray();
        int len = s.length();
        int[][] t = new int[len][2];
        int[] p = new int[len];
        int k = -1;
        int x = 0;
        int max = 0;

        for (int i = 0; i < len; i++) {
            if (k >= 0 && t[k][0] == '(' && c[i] == ')') {
                p[i] = 1;
                p[t[k][1]] = 1;
                k--;
            } else {
                t[++k][0] = c[i];
                t[k][1] = i;
            }
        }

        for (int i = 0; i < len; i++) {
            if (p[i] == 1) {
                x++;
            } else {
                max = max>x ? max : x;
                x = 0;
            }
        }

        return max>x ? max : x;
    }

    public static int longestValidParentheses2(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> index = new Stack<Integer>();

        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            if (chars[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                index.pop();
            } else {
                stack.push(chars[i]);
                index.push(i);
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        } else {
            int max = 0;
            while(!index.isEmpty()) {
                max = max > (len-1-index.peek()) ? max : (len-1-index.peek());
                len = index.pop();
            }
            max = max > len ? max : len;
            return max;
        }

    }

    public static int longestValidParentheses3(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}
