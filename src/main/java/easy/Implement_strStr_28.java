package easy;

/**
 * Created by chenlijie on 5/2/17.
 */
public class Implement_strStr_28 {

    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null || needle.length() > haystack.length())
            return -1;

        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length())))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(strStr(null, "abc") == -1);
//        System.out.println(strStr("abc", null) == -1);
//        System.out.println(strStr("abc", "abc") == 0);
//        System.out.println(strStr("aabcc", "abc") == 1);
//        System.out.println(strStr("adabcc", "abc") == 2);
        System.out.println(strStr("0abc", "abc") == 1);
//        System.out.println(strStr("adabcc", "adabcca") == -1);
    }
}
