package bit;

/**
 * Created by chenlijie on 9/25/17.
 */
public class DecimalToBinary {

    public static String convertToBinary(double d, int k) {
        StringBuilder builder = new StringBuilder();

        int p1 = (int)d;
        double p2 = d - p1;

        while (p1 > 0) {
            builder.insert(0, p1%2);
            p1 /= 2;
        }

        builder.append(".");

        while (k-- > 0) {
            p2 = p2 * 2;
            if (p2 > 1) {
                builder.append(1);
                p2 = p2 - 1;
            } else {
                builder.append(0);
            }
        }

        return builder.toString();
    }

    public static double convertToDecimal(String binary) {
        String[] str = binary.split("\\.");

        double d = 0;
        int len = str[0].length();
        for (int i = 0; i < len; i++) {
            if (str[0].charAt(len - 1 - i) == '1') {
                d += 1 << i;
            }
        }

        len = str[1].length();
        for (int i = 0; i < len; i++) {
            if (str[1].charAt(i) == '1') {
                d += Math.pow(0.5, i+1);
            }
        }

        return d;
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(4.47d, 3));
        System.out.println(convertToDecimal("110.101"));
        System.out.println(convertToDecimal("100.011"));
    }
}
