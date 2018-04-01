package microsoft;

public class ReverseWord {

    static String reverseWords(String s) {
        if (s == null)
            return null;

        char[] c = s.toCharArray();
        int len = c.length;

        for (int i = 0, j = 0; i < len;) {
            while (j < len && c[j] == ' ')
                j++;

            i = j;

            while (j < len && c[j] != ' ')
                j++;

            reverse(c, i, j - 1);
        }

        return new String(c);
    }

    static void reverse(char[] c, int i, int j) {
        while (i < j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Hello world   Java"));
    }
}
