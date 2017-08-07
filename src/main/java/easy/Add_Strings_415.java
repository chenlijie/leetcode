package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Add_Strings_415 {

    public static String addStrings(String num1, String num2) {

        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sum = new StringBuilder("");

        while (i1 >= 0 && i2 >= 0) {
            int temp = carry + num1.charAt(i1) + num2.charAt(i2) - 2*'0';
            sum.insert(0, temp%10);
            carry = temp/10;
            i1--;
            i2--;
        }

        while (i1 >= 0) {
            int temp = carry + num1.charAt(i1) - '0';
            sum.insert(0, temp%10);
            carry = temp/10;
            i1--;
        }

        while (i2 >= 0) {
            int temp = carry + num2.charAt(i2) - '0';
            sum.insert(0, temp%10);
            carry = temp/10;
            i2--;
        }

        if (carry == 1) {
            sum.insert(0, 1);
        }

        return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("6", "501"));
    }
}
