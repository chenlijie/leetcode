package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 4/17/17.
 */
public class Letter_Combinations_of_a_Phone_Number_17 {

    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return ans;

        backTracking(digits, 0, new char[digits.length()], ans);
        return ans;
    }

    void backTracking(String digits, int idx, char[] comb, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(new String(comb));
            return;
        }

        for (char c : map[digits.charAt(idx) - '0'].toCharArray()) {
            comb[idx] = c;
            backTracking(digits, idx + 1, comb, ans);
        }
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Letter_Combinations_of_a_Phone_Number_17().letterCombinations("010123"));

    }
}
