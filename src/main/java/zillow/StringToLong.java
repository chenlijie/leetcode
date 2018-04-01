package zillow;

public class StringToLong {

    static long stringToLong(String s) throws Exception{

        long ans = 0;
        long maxLastNum = Long.MAX_VALUE % 10;
        long minLastNum = -(Long.MIN_VALUE % 10);

        int i = 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            sign = 1;
            i++;
        }


        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                throw new Exception("invalid format");
            }

            if (sign > 0 && (ans > Long.MAX_VALUE/10 || (ans == Long.MAX_VALUE/10 && c - '0' > maxLastNum))) {
                throw new Exception("overflow");
            } else if (sign < 0 && (ans > Long.MAX_VALUE/10 || (ans == Long.MAX_VALUE/10 && c - '0' > minLastNum))) {
                throw new Exception("overflow");
            }

            ans = ans * 10 + c - '0';
        }
        ans *= sign;
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) throws Exception {
//        stringToLong("124 ");
//        stringToLong("12+4");
//        stringToLong("1a24");
//        stringToLong("12.4");
//        stringToLong("2912837543");
//        stringToLong("" + Long.MAX_VALUE);
//        stringToLong("9223372036854775808");

        System.out.println(Long.MAX_VALUE);
        System.out.println((long)(Math.pow(2L, 64) - 1));
        System.out.println(Long.MIN_VALUE);
        System.out.println((long)(-Math.pow(2L, 64)));

//        stringToLong("-328327");

//        stringToLong("+92233720368547758071");
    }
}
