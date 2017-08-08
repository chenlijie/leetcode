package medium;

/**
 * Created by chenlijie on 8/7/17.
 */
public class ZigZag_Conversion_6 {

    public static String convert(String s, int numRows) {
        if(s.length() == 0 || numRows == 1) {
            return s;
        }

        char[][] map = new char[numRows][s.length()];
        int column = 0;
        int index = 0;
        boolean flag = false;

        while (index < s.length()) {

            for (int i = 0; i < numRows; i++) {
                if (index >= s.length()) {
                    flag = true;
                    break;
                }
                map[i][column] = s.charAt(index++);
            }

            if (flag) {
                break;
            }

            for (int i = numRows-2; i > 0; i--) {
                if (index >= s.length()) {
                    flag = true;
                    break;
                }
                map[i][++column] = s.charAt(index++);
            }
            column++;

            if (flag) {
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j <= column; j++) {
                if (map[i][j] != '\u0000') {
                    builder.append(map[i][j]);
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A", 1).equals("A"));

        System.out.println(convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }
}
