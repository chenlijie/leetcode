package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 12/18/17.
 */
public class Remove_Invalid_Parentheses_301 {

    public List<String> removeInvalidParentheses(String s) {
        if (s == null) return new ArrayList<>();

        int left = 0;
        int right = 0;
        int other = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                left++;
            } else if (c[i] == ')') {
                if (left > right) {
                    right++;
                }
            } else {
                other++;
            }
        }

        Set<String> ans = new HashSet<>();
        helper(c, 0, 0, 0, right, 0, new char[2*right + other], ans);
        return new ArrayList<>(ans);
    }

    void helper(char[] c, int idx, int leftCnt, int rightCnt, int target, int resIdx, char[] res, Set<String> ans){

        if (leftCnt == target && rightCnt == target && resIdx == res.length) {
            ans.add(new String(res));
            return;
        }

        if (resIdx == res.length || idx == c.length) {
            return;
        }

        if (c[idx] == '(') {
            res[resIdx] = '(';
            //take it
            helper(c, idx+1, leftCnt+1, rightCnt, target, resIdx+1, res, ans);
            //not take it
            helper(c, idx+1, leftCnt, rightCnt, target, resIdx, res, ans);
        } else if (c[idx] == ')') {
            if (leftCnt > rightCnt) {
                res[resIdx] = ')';
                //take it
                helper(c, idx+1, leftCnt, rightCnt+1, target, resIdx+1, res, ans);
            }
            //not take it
            helper(c, idx+1, leftCnt, rightCnt, target, resIdx, res, ans);
        } else {
            res[resIdx] = c[idx];
            //take it
            helper(c, idx+1, leftCnt, rightCnt, target, resIdx+1, res, ans);
        }
    }

    public static void main(String[] args) {
        Remove_Invalid_Parentheses_301 r = new Remove_Invalid_Parentheses_301();
        System.out.println(r.removeInvalidParentheses(")"));
    }
}
