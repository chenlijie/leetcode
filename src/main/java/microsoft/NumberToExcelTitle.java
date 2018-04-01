package microsoft;

public class NumberToExcelTitle {

    static String toTitle(int num) {
        if (num <= 0)
            return "";

        char[] c = " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        if (num <= 26)
            return String.valueOf(c[num]);

        StringBuilder builder = new StringBuilder();

        while (num > 0) {
            builder.append(c[num % 26]);
            num /= 26;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(toTitle(0));
//        System.out.println(toTitle(1));
//        System.out.println(toTitle(2));
//        System.out.println(toTitle(26));
//        System.out.println(toTitle(27));
//        System.out.println(toTitle(28));
//        System.out.println(toTitle(703));

        int a = 1;
        int b = 2;
//        a = a^b;
//        b = a^b;
//        a = a^b;

        swap(a, b);

        System.out.println(a);
        System.out.println(b);

    }

    static void swap(int a, int b) {
        a = a^b;
        b = a^b;
        a = a^b;
    }
}
