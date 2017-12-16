package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenlijie on 12/11/17.
 */
public class Valid_Number_65 {

    static boolean isNumber(String s) {
        if (s == null)
            return false;

        Set<Character> allowed = new HashSet<>();
        for (char c = '0'; c <= '9'; c++) {
            allowed.add(c);
        }
        allowed.add('.');
        allowed.add('e');

        s = s.trim();

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }

        if (s.length() == 0 || ".".equals(s) || "e".equals(s))
            return false;

        char[] cs = s.toCharArray();

        int dotCnt = 0;
        int eCnt = 0;


        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            if (!allowed.contains(c)) {
                return false;
            }

            if ('.' == c) {
                dotCnt++;
            } else if('e' == c) {
                eCnt++;
            }

            if (dotCnt > 1 || eCnt > 1) {
                return false;
            }
        }

        int eIdx = s.indexOf('e');
        if (eIdx == 0 || eIdx == cs.length-1 || eIdx > 0 && (cs[eIdx-1] < '0' || cs[eIdx-1] > '9')) {
            return false;
        }

        int dotIdx = s.indexOf('.');
        if (dotIdx-1 >= 0 && cs[dotIdx-1] == 'e') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("G12"));
        System.out.println(isNumber("+"));
        System.out.println(isNumber("++"));

//        System.out.println(".".split(".").length);
//        System.out.println("a ".split(" ").length);
    }
}
