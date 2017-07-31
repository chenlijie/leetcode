package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Remove_Duplicate_Letters_316 {

    public static String removeDuplicateLetters(String s) {
        if (s == null ||s.length() == 0)
            return s;

        // 记录每个字符出现的次数
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // 找出当前最小字符
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;

            // 避免无字符可用
            if (--cnt[s.charAt(i) - 'a'] == 0)
                break;
        }

        // 除去字符串中已经append的字符的所有重复值
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
    public static void main(String[] args) {
        char[] c = new char[2];
        System.out.println(removeDuplicateLetters("bcdabc"));
    }
}
