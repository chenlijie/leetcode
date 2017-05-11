package easy;

/**
 * Created by chenlijie on 5/10/17.
 */
public class Valid_Palindrome_125 {

    public boolean isPalindrome(String s) {

        char[] c = s.toCharArray();
        int low = 0;
        int high = c.length - 1;

        while (low < high) {

            while (!isAlb(c[low]) && low < high) {
                low++;
            }

            while (!isAlb(c[high]) && high > 0) {
                high--;
            }

            if (low < high && !isSame(c[low], c[high])) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    private boolean isAlb(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean isSame(char c1, char c2) {
        if (((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')) && ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z'))) {
            return Math.abs(c1 - c2) == 0 || Math.abs(c1 - c2) == 32;
        }
        if (c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9') {
            return Math.abs(c1 - c2) == 0;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Valid_Palindrome_125().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new Valid_Palindrome_125().isPalindrome("A man, a plan, a canal: Panamaa"));
//        System.out.println(new Valid_Palindrome_125().isPalindrome(".,"));
        System.out.println(new Valid_Palindrome_125().isPalindrome("0P"));

        System.out.println('a'-1);
        System.out.println('A'-1);
        System.out.println('0'-1);
    }
}
