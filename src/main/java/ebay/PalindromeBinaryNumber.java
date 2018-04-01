package ebay;

import java.util.BitSet;

public class PalindromeBinaryNumber {

    /**
     *
     * 10 : 1010
     * 2|10        0
     *   2|5       1
     *    2|2      0
     *     2|1    1
     *
     *
     * 14 : 1110
     * 2|10        0
     *   2|7       1
     *    2|3      1
     *     2|1     1
     *
     */

    static boolean isPalindrome(int num) {
        int o = num;
        //get binary representation
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append(num % 2);
            num /= 2;
        }

        int len = 32 - builder.length();
        for (int i = 0; i < len; i++) {
            builder.append(0);
        }

        System.out.println("binary representation is " + builder.toString());

        int i = 0;
        int j = builder.length() - 1;

        while (i < j) {
            if (builder.charAt(i++) != builder.charAt(j--))
                return false;
        }

        System.out.println("binary representation of " + o + " is palindrome");
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(10);

//        System.out.println(Integer.toBinaryString(-Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(-10));

    }
}
