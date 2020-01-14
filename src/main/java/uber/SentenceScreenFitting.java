package uber;

import java.util.Arrays;
import java.util.Collections;

public class SentenceScreenFitting {

    static int wordsTyping(String[] sentence, int rows, int cols) {
        // Write your code here
        int k = 0;
        int len = sentence.length;

        for (int i = 0; i < rows; i++) {
            int width = sentence[k % len].length();

            while (width + 1 + sentence[(k+1) % len].length() <= cols) {
                width += 1 + sentence[(++k) % len].length();
            }

            k++;
        }

        System.out.println(k / len);
        return k / len;
    }

    public static void main(String[] args) {
        wordsTyping(new String[]{"aa", "bbbbbbbbbb"}, 1, 5);

        Arrays.sort(new int[][]{{1,2}, {0,2}}, (i1, i2) -> i1[0] - i2[0]);
    }
}
