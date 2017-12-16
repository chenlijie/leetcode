package linkedin;

/**
 * Created by chenlijie on 12/13/17.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null)
            return null;

        char[] c = s.toCharArray();
        int len = c.length;

        //reverse whole string
        reverse(c, 0, len-1);
        //reverse each word
        int i = 0;
        int j = 0;
        while (i < len) {
            //skip space
            while (i < len && c[i] == ' ') i++;
            j = i;
            //skip non space
            while (i < len && c[i] != ' ') i++;

            reverse(c, j, i-1);
        }

        //remove space
        i = 0;
        j = 0;
        while (i < len) {
            while (i < len && c[i] == ' ') i++;
            if (j != 0 && i < len) c[j++] = ' ';
            while (i < len && c[i] != ' ') c[j++] = c[i++];
        }

        return j-1 < 0 ? "" : new String(c, 0, j);
    }

    void reverse(char[] c, int i, int j) {
        while (i < j) {
            char t = c[i];
            c[i++] = c[j];
            c[j--] = t;
        }
    }

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println("|" + r.reverseWords("  abc  ") + "|");

        char[] c = new char[] {'1', '2', '3'};
        System.out.println(new String(c, 0,1));
    }
}
