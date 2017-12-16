package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/15/17.
 */
public class Text_Justification_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        int len = words.length;
        int i = 0;

        while (i < len) {
            int j = i;
            int left = maxWidth - words[j++].length();

            while (j < len && left >= 1 + words[j].length()) {
                left -= 1 + words[j].length();
                j++;
            }
            ans.add(buildLine(words, i, j-1, maxWidth));
            i = j;
        }

        return ans;
    }

    String buildLine(String[] words, int l, int r, int maxWidth) {
        StringBuffer buffer = new StringBuffer();
        if (r == words.length-1) {
            for (int i = l; i <= r; i++) {
                if (i == l) {
                    buffer.append(words[i]);
                } else {
                    buffer.append(" ").append(words[i]);
                }
            }

        } else {
            int spaceLen = maxWidth;
            for (int i = l; i <= r; i++) {
                spaceLen -= words[i].length();
            }

            int spaceNum = r == l ? spaceLen : spaceLen/(r - l);
            int spaceLeft = spaceLen - spaceNum*(r-l);
            StringBuffer space = new StringBuffer();
            for (int i = 0; i < spaceNum; i++) {
                space.append(" ");
            }


            for (int i = l; i <= r; i++) {
                if (i == l) {
                    buffer.append(words[i]);
                } else {
                    if (spaceLeft-- > 0) buffer.append(" ");
                    buffer.append(space).append(words[i]);
                }
            }
        }
        int left = maxWidth - buffer.length();
        for (int i = 0; i < left; i++) {
            buffer.append(" ");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Text_Justification_68 text = new Text_Justification_68();
        System.out.println(text.fullJustify(new String[]{"This", "is", "an", "example"}, 16));
    }
}
