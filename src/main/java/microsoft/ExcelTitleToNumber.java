package microsoft;

public class ExcelTitleToNumber {

    static int titleToNumber(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int j = 0;
        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

//            if (sum > Integer.MAX_VALUE/10)
//                return 0;

            int pre = sum;
            sum += (s.charAt(i) - 'A' + 1) * (int)Math.pow(26, j++);

            if (pre > sum)
                return 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ABDEEFEFEFEFEFSFASEFAEFAAAAAAAAEEEEEEEEE"));

    }
}
