package airbnb;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int len = words.length;

        for (int i = 0; i < len;) {
            int size = -1;
            int j = i;

            for (; j < len && size + words[j].length() + 1 <= maxWidth; j++) {
                size += words[j].length() + 1;
            }

            int space = 1;
            int extra = 0;

            if (j != len) {
                space = (maxWidth - len) / (j - i - 1) + 1;
                extra = (maxWidth - len) % (j - i - 1);
            }

            StringBuilder text = new StringBuilder(words[i]);


            for (int k = i + 1; k < j; k++) {
                for (int m = 0; m < space; m++) text.append(' ');
                if (extra-- > 0) text.append(' ');
                text.append(words[k]);
            }
            //total blank space
            int remain = maxWidth - text.length();
            while (remain-- > 0) text.append(' ');

            ans.add(text.toString());
            i = j;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        Text_Justification_68 jn = new Text_Justification_68();
//        jn.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "jus.", "bb"}, 16);
//        jn.fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
        jn.fullJustify(new String[]{""}, 0);
    }
}
