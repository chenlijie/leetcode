package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 4/17/17.
 */
public class Letter_Combinations_of_a_Phone_Number_17 {

    public List<String> letterCombinations(String digits) {
        List<String> all = new ArrayList<String>();
        if (digits.length() == 0) {
            return all;
        } else {
            letterCombinations(all, new ArrayList<Character>(), digits.toCharArray(), 0);
            return all;
        }
    }

    private char[] abc = new char[]{'a', 'b', 'c'};
    private char[] def = new char[]{'d', 'e', 'f'};
    private char[] ghi = new char[]{'g', 'h', 'i'};
    private char[] jkl = new char[]{'j', 'k', 'l'};
    private char[] mno = new char[]{'m', 'n', 'o'};
    private char[] pqrs = new char[]{'p', 'q', 'r', 's'};
    private char[] tuv = new char[]{'t', 'u', 'v'};
    private char[] wxyz = new char[]{'w', 'x', 'y', 'z'};
    private StringBuilder sb;

    private void letterCombinations(List<String> all, List<Character> temp, char[] digits, int start) {

        if (temp.size() == digits.length) {
            sb = new StringBuilder("");
            for (char s : temp) {
                sb.append(s);
            }
            all.add(sb.toString());
        } else {
            for (int i = start; i < digits.length; i++) {
                switch (digits[i]) {
                    case '2':
                        for (int j = 0; j < 3; j++) {
                            temp.add(abc[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '3':
                        for (int j = 0; j < 3; j++) {
                            temp.add(def[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '4':
                        for (int j = 0; j < 3; j++) {
                            temp.add(ghi[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '5':
                        for (int j = 0; j < 3; j++) {
                            temp.add(jkl[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '6':
                        for (int j = 0; j < 3; j++) {
                            temp.add(mno[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '7':
                        for (int j = 0; j < 4; j++) {
                            temp.add(pqrs[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '8':
                        for (int j = 0; j < 3; j++) {
                            temp.add(tuv[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    case '9':
                        for (int j = 0; j < 4; j++) {
                            temp.add(wxyz[j]);
                            letterCombinations(all, temp, digits, start+1);
                            temp.remove(temp.size()-1);
                        }
                        break;
                    default:
                        break;
                }
                break;
            }
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
        for (String str : new Letter_Combinations_of_a_Phone_Number_17().letterCombinations2("23")) {
            System.out.print(str + ", ");
        }
    }
}
