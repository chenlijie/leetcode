package easy;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Convert_a_Number_to_Hexadecimal_405 {

    public static String toHex(int num) {

        StringBuilder builder = new StringBuilder("");
        String[] hex = new String[8];

        for (int i = 0; i < 32; i+=4) {

            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += (1 & num) << j;
                num >>= 1;
            }

            if (sum < 10) {
                hex[i/4] = sum+"";
            } else {
                switch (sum) {
                    case 10 : hex[i/4] = "a"; break;
                    case 11 : hex[i/4] = "b"; break;
                    case 12 : hex[i/4] =  "c"; break;
                    case 13 : hex[i/4] =  "d"; break;
                    case 14 : hex[i/4] =  "e"; break;
                    case 15 : hex[i/4] =  "f"; break;
                }   
            }
        }

        for (int i = hex.length-1; i >= 0; i--) {
            if (!"0".equals(hex[i]) || builder.length() != 0) {
                builder.append(hex[i]);
            }
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(toHex(0));
        System.out.println(-4 >> 1);
        System.out.println(-4 >>> 1);
    }
}
