package facebook.fblist;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VersionSort {

//    排序string, 输入List, 输出排序的List e.g. a4b3 (a 是产品名称，4 是产品版本),
// a3b2, b1 => a3b2, a4b3, b1; followup, 没有产品名称只有版本，如 “1”，答这个会被放在返回List最前面

    static List<String> sort(List<String> versions) {
        /*Collections.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //check name

                int i1 = s1.indexOf('a');
                int i2 = s2.indexOf('a');

                if (i1 == i2) {
                    //contains a
                    if (i1 == 0) {
                        //contains b
                        i1 = s1.indexOf('b');
                        i2 = s2.indexOf('b');

                        int nameVersion1 = Integer.parseInt(s1.substring(1, i1));
                        int nameVersion2 = Integer.parseInt(s2.substring(1, i2));

                        return nameVersion1 == nameVersion2
                                ? Integer.parseInt(s1.substring(i1 + 1)) - Integer.parseInt(s1.substring(i2 + 1))
                                : nameVersion1 - nameVersion2;

                    } else {
                        //not contains a, start with b or it's just a number
                        i1 = s1.indexOf('b');
                        i2 = s2.indexOf('b');

                        if (i1 == i2) {
                            return i1 == 0
                                    ? Integer.parseInt(s1.substring(1)) - Integer.parseInt(s2.substring(1))
                                    : Integer.parseInt(s1) - Integer.parseInt(s2);
                        } else {
                            // one start with b, the other one is number
                            return i1 == -1 ? -1 : 1;
                        }
                    }
                } else {
                    // i1 = 0, i2 = -1 or i1 = -1, i2 = 0
                    if (i1 == 0) {
                        return s2.indexOf('b') != -1 ? 1 : -1;
                    } else {
                        return s1.indexOf('b') != -1 ? -1 : 1;
                    }
                }
            }
        });*/

        /*Collections.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int a1 = s1.indexOf('a');
                int a2 = s2.indexOf('a');
                int b1 = s1.indexOf('b');
                int b2 = s2.indexOf('b');

                if (a1 != -1 && b1 != -1 && a2 != -1 && b2 != -1) {
                    return s1.substring(1, b1).equals(s2.substring(1, b2))
                            ? Integer.parseInt(s1.substring(b1 + 1)) - Integer.parseInt(s2.substring(b2 + 1))
                            : Integer.parseInt(s1.substring(1, b1)) - Integer.parseInt(s2.substring(1, b2));
                } else if (b1 != -1 && a2 != -1 && b2 != -1) {
                    return 1;
                } else if (a1 != -1 && b1 != -1 && b2 != -1) {
                    return -1;
                } else if (b1 != -1 && b2 != -1) {
                    return Integer.parseInt(s1.substring(1)) - Integer.parseInt(s2.substring(1));
                } else if (b1 != -1) {
                    return 1;
                } else if (b2 != -1) {
                    return -1;
                } else {
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                }
            }
        });*/

        Collections.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dfs(s1, 0, s2, 0);
            }

            private int dfs(String s1, int pos1, String s2, int pos2) {
                if (s1.length() == pos1) {
                    return -1;
                } else if (s2.length() == pos2) {
                    return 1;
                }
                char c1 = s1.charAt(pos1);
                char c2 = s2.charAt(pos2);

                if (Character.isLetter(c1) && Character.isLetter(c2)) {
                    if (c1 == c2) {
                        int i1 = pos1 + 1;
                        while (i1 < s1.length() && Character.isDigit(s1.charAt(i1))) i1++;

                        int i2 = pos2 + 1;
                        while (i2 < s2.length() && Character.isDigit(s2.charAt(i2))) i2++;

                        if (s1.substring(pos1, i1).equals(s2.substring(pos2, i2))) {
                            return dfs(s1, i1, s2, i2);
                        }
                        return Integer.parseInt(s1.substring(pos1 + 1, i1)) - Integer.parseInt(s2.substring(pos2 + 1, i2));
                    }
                    return c1 - c2;
                } else if (Character.isLetter(c1)) {
                    return pos1 == 0 ? 1 : -1;
                } else if (Character.isLetter(c2)) {
                    return pos1 == 0 ? -1 : 1;
                } else {
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                }
            }
        });

       return versions;
    }

    public static void main(String[] args) {
//        System.out.println(sort(Arrays.asList("a4b3", "b13", "5", "b4", "13", "a23b1", "22", "a13b4", "a3b2", "b1")));
        System.out.println(sort(Arrays.asList("a4b3", "b13", "1", "ab3", "b5", "b4", "a13", "12", "a23b1", "c22", "a13b4", "a3b2", "2", "b1")));
    }
}
