package ebay;

import java.util.ArrayList;
import java.util.List;

public class SumTo100 {

    //Given a ordered set of integers from 1 to 9.
    //Combine them using + or - or nothing, such that the resulting equation

    static List<String> sumTo100() {
        List<String> ans = new ArrayList<>();
        helper("123456789", 0, 0, new StringBuilder(), ans);

        for (String s : ans) {
            System.out.println(s);
        }

        return ans;
    }

    static void helper(String str, int start, int sum, StringBuilder build, List<String> ans) {
        if (start == str.length()) {
            if (sum == 100)
                ans.add(build.toString());
            return;
        }

        int len = build.length();

        for (int i = start; i < str.length(); i++) {
            int num = Integer.parseInt(str.substring(start, i + 1));

            if (start == 0) {
                build.append(num);
                helper(str, i + 1, sum + num, build, ans);
            } else {
                build.append("+").append(num);
                helper(str, i + 1, sum + num, build, ans);
                build.setLength(len);

                build.append("-").append(num);
                helper(str, i + 1, sum - num, build, ans);
            }
            build.setLength(len);
        }
    }


    public static void main(String[] args) {
        sumTo100();
    }
}
