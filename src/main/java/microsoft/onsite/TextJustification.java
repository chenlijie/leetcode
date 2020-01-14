package microsoft.onsite;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            StringBuilder line = new StringBuilder(words[i]);
            int width = words[i].length();

            int j = i;
            while (j + 1 < len && width + words[j + 1].length() < maxWidth) {
                width += words[j + 1].length() + 1;
                j++;
            }

            int space = 0;
            int extra = 0;

            if (j != len - 1) {
                space = (maxWidth - width) / (j-i+1);
                extra = (maxWidth - width) % (j-i+1);
            }

            for (; i <= j; i++) {
                for (int k = 0; k <= space; k++)
                    line.append(' ');

                if (extra-- > 0)
                    line.append(' ');

                line.append(words[i]);
            }
            ans.add(line.toString());
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        fullJustify(new String[]{"this", "is", "good", "result.", "let's", "do", "it.", "happy"}, 10);
    }
}
