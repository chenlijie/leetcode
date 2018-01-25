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
        if (num.length() == 0) return ans;
        char[] c = num.toCharArray();
        helper(c, 1, '+', 0,c[0] - '0', 0, target, new StringBuilder(), ans);
        return ans;
    }

    void helper(char[] c, int idx, char op, int preNum1, int preNum2, int preSum, int tg, StringBuilder builder, List<String> ans) {
        if (idx == c.length) {
            builder.append(op).append(preNum2);
            if (op == '*') {
                if (calSum('+', 0, preNum1 * preNum2, preSum) == tg) {
                    ans.add(builder.toString());
                }
            } else {
                if (calSum(op, preNum1, preNum2, preSum) == tg) {
                    ans.add(builder.toString());
                }
            }
            return;
        }

        int len = builder.length();
        int curNum = c[idx] - '0';

        if (idx == 1)
            builder.append(preNum2);
        else
            builder.append(op).append(preNum2);

        if (op == '+' || op == '-') {
            //apply + or -
            helper(c, idx+1, '-', preNum1, curNum, calSum(op, preNum1, preNum2, preSum), tg, builder, ans);
            helper(c, idx+1, '+', preNum1, curNum, calSum(op, preNum1, preNum2, preSum), tg, builder, ans);

            //apply *
            helper(c, idx+1, '*', preNum2, curNum, preSum, tg, builder, ans);

            //append cur number to previous num
            if (curNum != 0) {
                helper(c, idx+1, op, preNum1, preNum2 * 10 + curNum, preSum, tg, builder, ans);
            }
        }

        if (op == '*') {
            //previous operation is + or -
            helper(c, idx+1, '+', 0, curNum, calSum('+', 0, preNum1 * preNum2, preSum), tg, builder, ans);
            helper(c, idx+1, '+', 0, curNum, calSum('-', 0, preNum1 * preNum2, preSum), tg, builder, ans);

            //apply *
            helper(c, idx+1, '*', preNum1 * preNum2, curNum, preSum, tg, builder, ans);

            //append cur number to previous num
            helper(c, idx+1, op, preNum1, preNum2 * 10 + curNum, preSum, tg, builder, ans);
        }

        builder.setLength(len);
    }

    int calSum(char op, int preNum1, int preNum2, int preSum) {
        if (op == '+') {
            return preSum + preNum2;
        } else if (op == '-') {
            return preSum - preNum2;
        } else {
            return preSum + preNum1 * preNum2;
        }
    }

    public static void main(String[] args) {
        Expression_Add_Operators_282 exp = new Expression_Add_Operators_282();
        System.out.println(exp.addOperators("232", 6));
    }
}
