package linkedin;

/**
 * Created by chenlijie on 12/12/17.
 */
public class SumOfNumInString {

    static int findSum(String str) {

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {

            while (i < str.length() && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
                i++;
            }
            int idx = i;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                i++;
            }

            if (i > idx) {
                sum += Integer.valueOf(str.substring(idx, i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findSum("abc") == 0);
        System.out.println(findSum("12") == 12);
        System.out.println(findSum("") == 0);
        System.out.println(findSum("a1b2c3") == 6);
        System.out.println(findSum("1a1bc10") == 12);
    }
}
