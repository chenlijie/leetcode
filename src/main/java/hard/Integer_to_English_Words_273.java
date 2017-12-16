package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 12/15/17.
 */
public class Integer_to_English_Words_273 {

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int k = 0;
        StringBuffer buffer = new StringBuffer();

        while (num != 0) {
            int third = num%10;
            num /= 10;
            int second = num%10;
            num /= 10;
            int first = num%10;
            num /= 10;

            StringBuffer str = new StringBuffer();
            str.append(NumWord.getNumString(first, second, third));

            if (k == 1 && str.length() != 0) {
                str.append(" ").append("Thousand");
            } else if (k == 2 && str.length() != 0) {
                str.append(" ").append("Million");
            } else if (k == 3 && str.length() != 0) {
                str.append(" ").append("Billion");
            }

            if (buffer.length() != 0 && str.length() != 0) {
                buffer.insert(0, " ");
            }
            buffer.insert(0, str);
            k++;
        }

        return buffer.toString();
    }

    static class NumWord {
        static Map<Integer, String> map1 = new HashMap<>();
        static Map<Integer, String> map2 = new HashMap<>();

        static {
            map1.put(1, "One");
            map1.put(2, "Two");
            map1.put(3, "Three");
            map1.put(4, "Four");
            map1.put(5, "Five");
            map1.put(6, "Six");
            map1.put(7, "Seven");
            map1.put(8, "Eight");
            map1.put(9, "Nine");

            map2.put(10, "Ten");
            map2.put(11, "Eleven");
            map2.put(12, "Twelve");
            map2.put(13, "Thirteen");
            map2.put(14, "Fourteen");
            map2.put(15, "Fifteen");
            map2.put(16, "Sixteen");
            map2.put(17, "Seventeen");
            map2.put(18, "Eighteen");
            map2.put(19, "Nineteen");
            map2.put(2, "Twenty");
            map2.put(3, "Thirty");
            map2.put(4, "Forty");
            map2.put(5, "Fifty");
            map2.put(6, "Sixty");
            map2.put(7, "Seventy");
            map2.put(8, "Eighty");
            map2.put(9, "Ninety");
        }

        public static String getNumString(int first, int second, int third) {
            StringBuffer buffer = new StringBuffer();
            if (first != 0)
                buffer.append(map1.get(first)).append(" ").append("Hundred");

            if(second == 1) {
                if (buffer.length() != 0)
                    buffer.append(" ");
                buffer.append(map2.get(10 + third));
            } else {
                if (second != 0) {
                    if (buffer.length() != 0)
                        buffer.append(" ");
                    buffer.append(map2.get(second));
                }
                if (third != 0) {
                    if (buffer.length() != 0)
                        buffer.append(" ");
                    buffer.append(map1.get(third));
                }
            }

            return buffer.toString();
        }
    }

    public static void main(String[] args) {
        Integer_to_English_Words_273 word = new Integer_to_English_Words_273();
        System.out.println(word.numberToWords(1000010));
    }
}
