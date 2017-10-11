package hard;

/**
 * Created by chenlijie on 9/11/17.
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters_159 {

    /**
     * k = 3
     * A B C D
     * 1 1 1 1
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int[] map = new int[256];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
//            if (map[s.charAt(i)] == 0) {
//                count++;
//            }
            map[s.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int begin = 0;
        int end = 0;

        while (right < s.length()) {
            if (map[s.charAt(right++)]-- == 0) {
                count++;
            }

            while (count < k) {

            }
        }

        return 0;
    }
}
