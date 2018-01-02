package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenlijie on 12/21/17.
 */
public class Expression_Add_Operators_282 {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int len = num.length();
        for (int i = 0; i < num.length(); i++) {
            Stack<Integer> stack = new Stack<>();
            if (num.charAt(0) == '0') {
                stack.push(0);
                builder.append(0);
                helper(num.substring(1), stack, builder, target, ans);
                break;
            } else {
                Integer n = Integer.valueOf(num.substring(0, i+1));
                stack.push(n);
                builder.append(n);
                helper(num.substring(i+1), stack, builder, target, ans);
            }
            builder.setLength(0);
        }

        return ans;
    }

    void helper(String num, Stack<Integer> stack, StringBuilder builder, int target, List<String> ans) {
        if ("".equals(num)) {
            Stack<Integer> copy = new Stack<>();
            copy.addAll(stack);
            if (getStackSum(copy) == target)
                ans.add(builder.toString());
            return;
        }

        int len = builder.length();
        for (int i = 0; i < num.length(); i++) {
            //if add +, just push num to stack
            Stack<Integer> copy = new Stack<>();
            copy.addAll(stack);
            if (num.charAt(0) == '0') {
                copy.push(0);
                builder.append('+').append(0);
                helper(num.substring(1), copy, builder, target, ans);
            } else {
                Integer n = Integer.valueOf(num.substring(0, i+1));
                copy.push(n);
                builder.append('+').append(n);
                helper(num.substring(i+1), copy, builder, target, ans);
            }
            builder.setLength(len);

            //if add -, just push num to stack
            copy.clear();
            copy.addAll(stack);
            if (num.charAt(0) == '0') {
                copy.push(0);
                builder.append('-').append(0);
                helper(num.substring(1), copy, builder, target, ans);
            } else {
                Integer n = Integer.valueOf(num.substring(0, i+1));
                copy.push(-n);
                builder.append('-').append(n);
                helper(num.substring(i+1), copy, builder, target, ans);
            }
            builder.setLength(len);

            //if add *, just push num to stack
            copy.clear();
            copy.addAll(stack);
            if (num.charAt(0) == '0') {
                copy.pop();
                copy.push(0);
                builder.append('*').append(0);
                helper(num.substring(1), copy, builder, target, ans);
            } else {
                Integer n = Integer.valueOf(num.substring(0, i+1));
                copy.push(n * copy.pop());
                builder.append('*').append(n);
                helper(num.substring(i+1), copy, builder, target, ans);
            }
            builder.setLength(len);

            if (num.charAt(0) == '0') break;
        }
    }

    Integer getStackSum(Stack<Integer> stack) {
        Integer sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Expression_Add_Operators_282 exp = new Expression_Add_Operators_282();
        System.out.println(exp.addOperators("10", 0));

//        System.out.println(Integer.MAX_VALUE);

        System.out.println(Integer.valueOf(" 9"));
    }
}
