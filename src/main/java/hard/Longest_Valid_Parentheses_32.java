package hard;

import java.util.*;

/**
 * Created by chenlijie on 4/13/17.
 */
public class Longest_Valid_Parentheses_32 {

    public static int longestValidParentheses4(String s) {

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


    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == '(' && s.charAt(i) == ')') {
                max = Math.max(max, helper(s, i-1, i) + 2);
            }
        }
        return max;
    }

    int helper(String s, int l, int r) {
        int left = 0;
        int mid = 0;
        int right = 0;
        if (l - 2 >= 0 && s.charAt(l-2) == '(' && s.charAt(l-1) == ')') {
            left = 2 + helper(s, l-2, r);
        }
        if (l - 1 >= 0 && r + 1 < s.length() && s.charAt(l-1) == '(' && s.charAt(r+1) == ')') {
            mid = 2 + helper(s, l-1, r + 1);
        }
        if (r + 2 < s.length() && s.charAt(r+1) == '(' && s.charAt(r+2) == ')') {
            right = 2 + helper(s, l, r + 2);
        }
        return Math.max(left, Math.max(mid, right));
    }

    public static void main(String[] args) {
//        Longest_Valid_Parentheses_32 v = new Longest_Valid_Parentheses_32();
//        System.out.println(v.longestValidParentheses("((((()())()()))()(()))"));

        List<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());
    }
}
