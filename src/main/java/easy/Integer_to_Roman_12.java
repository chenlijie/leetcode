package easy;

/**
 * Created by chenlijie on 4/14/17.
 */
public class Integer_to_Roman_12 {

    /*
        I	1
        IV  4
        V	5
        IX  9
        X	10
        XL  40
        L	50
        XC  90
        C	100
        CD  400
        D	500
        CM  900
        M	1000
    */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder("");

        int m = num/1000;
        for (int i = 0; i < m; i++) {
            sb.append("M");
        }
        num %= 1000;

        m = num/900;
        for (int i = 0; i < m; i++) {
            sb.append("CM");
        }
        num %= 900;

        m = num/500;
        for (int i = 0; i < m; i++) {
            sb.append("D");
        }
        num %= 500;

        m = num/400;
        for (int i = 0; i < m; i++) {
            sb.append("CD");
        }
        num %= 400;

        m = num/100;
        for (int i = 0; i < m; i++) {
            sb.append("C");
        }
        num %= 100;

        m = num/90;
        for (int i = 0; i < m; i++) {
            sb.append("XC");
        }
        num %= 90;

        m = num/50;
        for (int i = 0; i < m; i++) {
            sb.append("L");
        }
        num %= 50;

        m = num/40;
        for (int i = 0; i < m; i++) {
            sb.append("XL");
        }
        num %= 40;

        m = num/10;
        for (int i = 0; i < m; i++) {
            sb.append("X");
        }
        num %= 10;

        m = num/9;
        for (int i = 0; i < m; i++) {
            sb.append("IX");
        }
        num %= 9;

        m = num/5;
        for (int i = 0; i < m; i++) {
            sb.append("V");
        }
        num %= 5;

        m = num/4;
        for (int i = 0; i < m; i++) {
            sb.append("IV");
        }
        num %= 4;

        m = num;
        for (int i = 0; i < m; i++) {
            sb.append("I");
        }

        return sb.toString();
    }
}
