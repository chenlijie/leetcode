package oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/29/17.
 */
public class PasswordGenerator {

    List<String> generate(String p) {
        List<String> res = new ArrayList<>();
        helper(p, 0, "", res);
        return res;
    }

    void helper(String p, int i, String r, List<String> res) {
        if (i == p.length()) {
            res.add(r);
            return;
        }

        char c = p.charAt(i);
        if (c == 'a' || c == 'A') {
            helper(p, i+1, r + c, res);
            helper(p, i+1, r + '@', res);
        } else if (c == 's' || c == 'S') {
            helper(p, i+1, r + c, res);
            helper(p, i+1, r + '$', res);
        } else {
            helper(p, i+1, r + c, res);
        }
    }

    public static void main(String[] args) {
        PasswordGenerator p = new PasswordGenerator();
        System.out.println(p.generate("Password"));
    }
}
