package medium;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Multiply_Strings_43 {

    public static String multiply(String num1, String num2) {

        int last1 = num1.length()-1;
        int last2 = num2.length()-1;
        int[] total = new int[last1 + last2 + 2];

        for (int i = last1; i >= 0; i--) {
            for (int j = last2; j >= 0; j--) {
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0')
                        + total[last1 - i + last2 - j];

                total[last1 - i + last2 - j] = p%10;
                total[last1 - i + last2 - j + 1] += p/10;
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = last1 + last2 + 1;
        while (i >= 0 && total[i] == 0) {
            i--;
        }
        while (i >= 0) {
            ans.append(total[i--]);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("98", "9"));
    }
}
