package zillow;

public class StringToFloat {

//    "-5"    => -5.0
//    "3/4"  => 0.75
//    "1 3/4"  => 1.75

    static float stringToFloat(String str) {

        str = str.trim();
        int sign = 1;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            sign = -1;
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        float ans = 0.0F;
        String[] nums = str.split(" ");
        String decimal = nums[0];

        if (nums.length == 2) {
            ans += Float.parseFloat(nums[0]);
            decimal = nums[1];
        }

        String[] decimalPart = decimal.split("/");
        if (decimalPart.length == 2)
            ans += Float.parseFloat(decimalPart[0]) / Float.parseFloat(decimalPart[1]);
        else
            ans += Float.parseFloat(decimalPart[0]);

        if (ans == 0.0F) {
            System.out.println(ans);
            return ans;
        } else {
            ans *= sign;
            System.out.println(ans);
            return ans;
        }


    }

    public static void main(String[] args) {
        stringToFloat("0");
        stringToFloat("-0");

        stringToFloat("+5");
        stringToFloat("-5");

        stringToFloat("3/4");
        stringToFloat("-3/4");

        stringToFloat("+1 3/4");
        stringToFloat("-1 3/4");
    }
}
