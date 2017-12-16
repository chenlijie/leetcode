package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Permutation_in_String_567 {

    public static boolean checkInclusion2(String s1, String s2) {

        int count = s1.length();
        int[] targets = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            targets[s1.charAt(i)]++;
        }

        for (int left = 0, right = 0; right < s2.length(); right++) {

            if (targets[s2.charAt(right)] > 0) {
                targets[s2.charAt(right)]--;
                count--;
            } else {
                while (left <= right) {
                    targets[s2.charAt(left++)]++;
                    count++;
                }
                count = right;
            }

            if (count == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len = s2.length();
        int[] c = new int[256];

        for (int i = 0; i < len1; i++) {
            c[s1.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        while (right < len) {
            while (right < len) {
                if (--c[s2.charAt(right++)] < 0) {
                    break;
                }
            }

            while (left < right && c[s2.charAt(right-1)] < 0) {
                c[s2.charAt(left++)]++;
            }

            if (len1 == right - left)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eba"));
    }
}
