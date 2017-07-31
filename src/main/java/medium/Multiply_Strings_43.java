package medium;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Multiply_Strings_43 {

    public static String multiply(String num1, String num2) {

        int[] t = new int[num1.length() + num2.length()];

        for (int i = num1.length()-1; i >= 0; i--) {

            for (int j = num2.length()-1; j >= 0; j--) {
                t[t.length-i-j-2] = t[t.length-i-j-2] + Integer.valueOf(num1.substring(i, i+1)) * Integer.valueOf(num2.substring(j, j+1));
            }
        }

        StringBuilder builder = new StringBuilder("");
        int carry = 0;
        for (int i = 0 ; i < t.length; i++) {
            if (t[i] != 0 || (i+1) != t.length) {
                t[i] += carry;
                carry = t[i]/10;
                builder.insert(0, t[i]%10);
            }
        }
        if (carry != 0) {
            builder.insert(0, carry);
        }
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("0", "0").equals(String.valueOf(0*0)));
    }
}
