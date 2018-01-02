package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 12/18/17.
 */
public class Remove_Invalid_Parentheses_301_2 {

    public List<String> removeInvalidParentheses(String s) {
        if (s == null) return new ArrayList<>();

        int rmL = 0;
        int rmR = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                rmL++;
            } else if (c[i] == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }

        Set<String> ans = new HashSet<>();
        helper(c, 0, rmL, rmR, 0, new char[c.length - rmL - rmR], ans, 0);
        return new ArrayList<>(ans);
    }

    void helper(char[] c, int idx, int rmL, int rmR, int resIdx, char[] res, Set<String> ans, int open){

        if (idx == c.length) {
            if (rmL == 0 && rmR == 0) {
                ans.add(new String(res));
            }
            return;
        }

        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }

        if (c[idx] == '(') {
            if (resIdx < res.length)
                res[resIdx] = '(';
            //take it
            helper(c, idx+1, rmL, rmR, resIdx+1, res, ans, open + 1);
            //not take it
            helper(c, idx+1, rmL - 1, rmR, resIdx, res, ans, open);
        } else if (c[idx] == ')') {
            if (resIdx < res.length)
                res[resIdx] = ')';
            //take it
            helper(c, idx+1, rmL, rmR, resIdx+1, res, ans, open - 1);
            //not take it
            helper(c, idx+1, rmL, rmR - 1, resIdx, res, ans, open);
        } else {
            res[resIdx] = c[idx];
            //take it
            helper(c, idx+1, rmL, rmR, resIdx+1, res, ans, open);
        }
    }

    public static void main(String[] args) {
        Remove_Invalid_Parentheses_301_2 r = new Remove_Invalid_Parentheses_301_2();
        System.out.println(r.removeInvalidParentheses("("));
    }
}
