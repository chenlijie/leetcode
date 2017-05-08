package easy;

public class Find_the_Difference_389 {

    public static char findTheDifference(String s, String t) {

        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();

        int len = sChars.length;

        int code = tChars[len];
        for (int i = 0; i < len; i++) {
            code = code + tChars[i] - sChars[i];
        }

        return (char)code;
    }

    public static char findTheDifference2(String s, String t) {

        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();

        int len = sChars.length;

        int code = tChars[len];
        for (int i = 0; i < len; i++) {
            code ^= tChars[i]^sChars[i];
        }

        return (char)code;
    }
}
