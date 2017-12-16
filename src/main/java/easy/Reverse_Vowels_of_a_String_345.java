package easy;

/**
 * Created by chenlijie on 11/18/17.
 */
public class Reverse_Vowels_of_a_String_345 {

    public String reverseVowels(String s) {
        if (s == null)
            return null;

        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();

        while (i < j) {
            while (i < j && !isVowel(c[i])) {
                i++;
            }

            while (j > i && !isVowel(c[j])) {
                j--;
            }

            if (i < j) {
                swap(c, i, j);
            }
            i++;
            j--;
        }

        return new String(c);
    }

    boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'o' || c == 'O' || c == 'u' || c == 'U'|| c == 'i' || c == 'I')
            return true;
        return false;
    }

    void swap(char[] c, int i, int j) {
        char x = c[i];
        c[i] = c[j];
        c[j] = x;
    }

    public static void main(String[] args) {
        Reverse_Vowels_of_a_String_345 r = new Reverse_Vowels_of_a_String_345();
        System.out.println(r.reverseVowels("ai"));
    }
}
