package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Length_of_Last_Word_58 {

    public static int lengthOfLastWord(String s) {

        int len = s.length();
        int start = 0;

        int end = len-1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }


        for (int i = end-1; i >= 0; i--) {

            if (s.charAt(i) == ' ') {
                start = i+1;
                break;
            }
        }

        return end-start+1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("  av "));
    }
}
