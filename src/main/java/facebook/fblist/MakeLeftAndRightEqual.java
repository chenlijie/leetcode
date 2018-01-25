package facebook.fblist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeLeftAndRightEqual {

    List<String> makeEqual(String left, String right) {
        if (left == null || left.length() == 0 || right == null || right.length() == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> leftRes = new HashMap<>();
        helper(left, new StringBuilder(), 0, 0, leftRes);

        Map<Integer, List<String>> rightRes = new HashMap<>();
        helper(right, new StringBuilder(), 0, 0, rightRes);

        List<String> ans = new ArrayList<>();
        for (Integer key : leftRes.keySet()) {
            if (rightRes.containsKey(key)) {
                for (String l : leftRes.get(key)) {
                    for (String r : rightRes.get(key)) {
                        ans.add(l + "=" + r);
                    }
                }
            }
        }
        return ans;
    }

    void helper(String s, StringBuilder path, int pos, int sum, Map<Integer, List<String>> res) {
        if (pos == s.length()) {
            res.putIfAbsent(sum, new ArrayList<>());
            res.get(sum).add(path.toString());
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            int len = path.length();
            if (s.charAt(pos) == '0') {
                helper(s, path.append("+0"), i + 1, sum, res);
                path.setLength(len);
                helper(s, path.append("-0"), i + 1, sum, res);
                path.setLength(len);
                break;
            }

            int num = Integer.parseInt(s.substring(pos, i + 1));
            helper(s, path.append("+").append(num), i + 1, sum + num, res);
            path.setLength(len);
            helper(s, path.append("-").append(num), i + 1, sum - num, res);
            path.setLength(len);
        }
    }

    public static void main(String[] args) {
        MakeLeftAndRightEqual make = new MakeLeftAndRightEqual();
        System.out.println(make.makeEqual("1", "1"));
    }
}
