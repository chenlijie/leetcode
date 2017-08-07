package easy;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Number_of_Segments_in_a_String_434 {

    public static int countSegments(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }

            if (i >= s.length()) {
                break;
            }

            if (s.charAt(i) != ' ') {
                count++;
            }

            if (i >= s.length()) {
                break;
            }

            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(" a aa   B  A"));
    }
}
