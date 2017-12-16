package easy;

/**
 * Created by chenlijie on 12/10/17.
 */
public class ValidParentheses {

    static boolean valid(String s) {
        if (s == null)
            return true;

        int left = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                left++;
            else
                left--;

            if (left < 0)
                return false;
        }
        return left == 0;
    }

    public static void main(String[] args) {
        System.out.println(valid("(") == false);
        System.out.println(valid(")") == false);
        System.out.println(valid("()") == true);
        System.out.println(valid("()(())()((()))") == true);
        System.out.println(valid("((()()))") == true);
        System.out.println(valid("(()(()())") == false);
    }
}
