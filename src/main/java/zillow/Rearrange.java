package zillow;

import java.util.Arrays;

public class Rearrange {

    static class Letter {
        char letter;
        int count;

        public Letter(char letter) {
            this.letter = letter;
            count = 1;
        }
    }

    static String rearrange(String str) {
        Letter[] letters = new Letter[26];

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (letters[idx] == null) {
                letters[idx] = new Letter(str.charAt(i));
            } else {
                letters[idx].count++;
            }
        }

        Arrays.sort(letters, (l1, l2) -> l1 == null ? 1 : l2 == null ? -1 : l2.count - l1.count);

        char[] ans = new char[str.length()];

        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < str.length(); j += 2) {
                while (letters[k] == null || letters[k].count == 0) k++;
                ans[j] = letters[k].letter;
                letters[k].count--;
            }
        }

        String t = new String(ans);
        System.out.println(t);
        return t;
    }

    public static void main(String[] args) {
        rearrange("a");
        rearrange("aabb");
        rearrange("bcaaabc");
    }
}
