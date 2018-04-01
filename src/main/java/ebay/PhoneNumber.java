package ebay;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[] nums = digits.toCharArray();

        backTracking(nums, 0, new StringBuilder(), ans);

        System.out.println(ans);
        return ans;
    }

    void backTracking(char[] digits, int start, StringBuilder str, List<String> ans) {
        if (digits.length == start) {
            if (str.length() > 0)
                ans.add(str.toString());
            return;
        }

        int len = str.length();
        for (int i = start; i < digits.length; i++) {

            for (char c : map[digits[i] - '0'].toCharArray()) {
                str.append(c);
                backTracking(digits, i + 1, str, ans);
                str.setLength(len);
            }

        }
    }

    public static void main(String[] args) {
        PhoneNumber phone = new PhoneNumber();
        phone.letterCombinations("22");
    }
}
