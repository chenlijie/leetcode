package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/22/17.
 */
public class StringCompare {

    static int isGreatThan(String s1, String s2) {
        int i1 = 0;
        int i2 = 0;
        int len1 = s1.length();
        int len2 = s2.length();

        while (i1 < len1 && i2 < len2) {
            char c1 = s1.charAt(i1);
            char c2 = s2.charAt(i2);

            //find any alphabet
            if (Character.isAlphabetic(c1) || Character.isAlphabetic(c2)) {
                if (Character.isDigit(c1)) {
                    return 1;
                } else if (Character.isDigit(c2)) {
                    return -1;
                } else if (c1 != c2) {
                    return c1 - c2 > 0 ? 1 : -1;
                }
            } else {
                int j1 = i1;
                while (j1 < len1 && Character.isDigit(s1.charAt(j1))) j1++;

                int j2 = i2;
                while (j2 < len2 && Character.isDigit(s2.charAt(j2))) j2++;

                int res = compareNumString(s1, i1, j1, s2, i2, j2);
                if (res > 0) {
                    return 1;
                } else if (res < 0) {
                    return -1;
                }
            }
            i1++;
            i2++;
        }

        return i1 != len1 ? 1 : i2 != len2 ? -1 : 0;
    }

    static int compareNumString(String s1, int i1, int j1, String s2, int i2, int j2) {
        //skip 0
        while (i1 < j1 && s1.charAt(i1) == 0) i1++;
        while (i2 < j2 && s2.charAt(i1) == 0) i2++;

        if (j1 - i1 > j2 - i2) {
            return 1;
        } else if (j1 - i1 < j2 - i2) {
            return -1;
        }

        while (i1 < j1) {
            if (s1.charAt(i1) > s2.charAt(i2)) {
                return 1;
            } else if (s1.charAt(i1) < s2.charAt(i2)) {
                return -1;
            }
            i1++;
            i2++;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(isGreatThan("", ""));
//        System.out.println(isGreatThan("b", "a"));
//        System.out.println(isGreatThan("b", "c"));
//        System.out.println(isGreatThan("2", "a"));
//        System.out.println(isGreatThan("b", "1"));
//        System.out.println(isGreatThan("2", "1"));
//        System.out.println(isGreatThan("abc", "ab2"));
        System.out.println(isGreatThan("12345a", "12345"));

        List[] lists = new List[3];
        for (List l : lists)
            l = new ArrayList();

        lists[0].add(1);
    }
}
