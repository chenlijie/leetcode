package easy;

import java.util.HashSet;
import java.util.Set;

public class Keyboard_Row_500 {

    public static String[] findWords(String[] words) {
        Set<Integer> row1 = new HashSet<Integer>();
        row1.add((int)'q'); row1.add((int)'Q');
        row1.add((int)'w'); row1.add((int)'W');
        row1.add((int)'e'); row1.add((int)'E');
        row1.add((int)'r'); row1.add((int)'R');
        row1.add((int)'t'); row1.add((int)'T');
        row1.add((int)'y'); row1.add((int)'Y');
        row1.add((int)'u'); row1.add((int)'U');
        row1.add((int)'i'); row1.add((int)'I');
        row1.add((int)'o'); row1.add((int)'O');
        row1.add((int)'p'); row1.add((int)'P');

        Set<Integer> row2 = new HashSet<Integer>();
        row2.add((int)'a'); row2.add((int)'A');
        row2.add((int)'s'); row2.add((int)'S');
        row2.add((int)'d'); row2.add((int)'D');
        row2.add((int)'f'); row2.add((int)'F');
        row2.add((int)'g'); row2.add((int)'G');
        row2.add((int)'h'); row2.add((int)'H');
        row2.add((int)'j'); row2.add((int)'J');
        row2.add((int)'k'); row2.add((int)'K');
        row2.add((int)'l'); row2.add((int)'L');

        Set<Integer> row3 = new HashSet<Integer>();
        row3.add((int)'z'); row3.add((int)'Z');
        row3.add((int)'x'); row3.add((int)'X');
        row3.add((int)'c'); row3.add((int)'C');
        row3.add((int)'v'); row3.add((int)'V');
        row3.add((int)'b'); row3.add((int)'B');
        row3.add((int)'n'); row3.add((int)'N');
        row3.add((int)'m'); row3.add((int)'M');

        String[] finds = new String[words.length];
        int len;
        int j = 0;
        for (String word : words) {
            len = word.length();
            int i = 0;

            if (row1.contains((int)word.charAt(0))) {
                for (i=1; i<len; i++) {
                    if (!row1.contains((int)word.charAt(i)))
                        break;
                }
            } else if (row2.contains((int)word.charAt(0))) {
                for (i=1; i<len; i++) {
                    if (!row2.contains((int)word.charAt(i)))
                        break;
                }
            } else {
                for (i=1; i<len; i++) {
                    if (!row3.contains((int)word.charAt(i)))
                        break;
                }
            }

            if (i == len) {
                finds[j++] = word;
            }
        }

        String[] result = new String[j];
        for (int i = 0; i < j; i++) {
            result[i] = finds[i];
        }

        return result;
    }
}
