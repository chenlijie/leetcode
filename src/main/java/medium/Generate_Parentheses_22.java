package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 4/12/17.
 */
public class Generate_Parentheses_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, 0, 0, n, "");
        return list;
    }

    private static void backTrack(List<String> list, int left, int right, int n, String s) {
        if (s.length() == 2*n) {
            list.add(s);
            return;
        }

        if (left < n) {
            backTrack(list, left+1, right, n, s+"(");
        }

        if (right < left) {
            backTrack(list, left, right+1, n, s+")");
        }

    }


    public static void main(String [] args) {
        List<String> list = generateParenthesis(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
