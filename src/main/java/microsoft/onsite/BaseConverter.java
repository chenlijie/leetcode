package microsoft.onsite;

public class BaseConverter {

    static String convert(String num, int from, int to) {
        //TODO
        StringBuilder builder = new StringBuilder();
        char[] c = num.toCharArray();

        if (from < to) {
            int p = 0;
            for (int i = c.length - 1; i >= 0; i--) {
                builder.insert(0, (c[i] - '0') * Math.pow(from, p++));
            }
        }

        return "";
    }
}
