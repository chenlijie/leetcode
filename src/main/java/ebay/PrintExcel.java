package ebay;

import java.util.Arrays;

public class PrintExcel {

    static String printExcel(int num) {
        char[] letters = new char[26];

        for (int i = 0; i < 26; i++) {
            letters[i] = (char)(i + 'A');
        }

        StringBuilder builder = new StringBuilder();

        while (num > 0) {
            builder.append(letters[num % 26]);
            num /= 26;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + " = " + printExcel(i));
        }

    }
}
