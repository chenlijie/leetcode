package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Add_Binary_67 {

    public static String addBinary(String a, String b) {

        StringBuilder builder = new StringBuilder("");
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int carry = 0;

        while (aIndex >= 0 && bIndex >= 0) {
            int sum = carry + Integer.valueOf(a.substring(aIndex, aIndex+1)) + Integer.valueOf(b.substring(bIndex, bIndex+1));

            builder.insert(0, sum%2);
            carry = sum/2;

            aIndex--;
            bIndex--;
        }

        while (aIndex >= 0) {
            int sum = carry + Integer.valueOf(a.substring(aIndex, aIndex+1));

            builder.insert(0, sum%2);
            carry = sum/2;

            aIndex--;
        }

        while (bIndex >= 0) {
            int sum = carry + Integer.valueOf(b.substring(bIndex, bIndex+1));

            builder.insert(0, sum%2);
            carry = sum/2;

            bIndex--;
        }

        if (carry == 1) {
            builder.insert(0, 1);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1", "111"));
    }
}
