package microsoft.onsite;

public class DoubleToString {

    static void convertDoubleToString(double num) {
        StringBuilder builder = new StringBuilder();
        double intPart = 0;

        double copy = num;
        while (copy >= 1 || copy <= -1) {
            int mod = (int)(copy % 10);
            intPart += mod * Math.pow(10, builder.length());
            builder.insert(0, mod);
            copy /= 10;
        }

        builder.append(".");
        copy = num - intPart;
        while (copy != 0) {
            int x = (int)(copy * 10);
            builder.append(x);
            copy = copy * 10 - x;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        double d = 32.32;
        convertDoubleToString(d);

        String.valueOf(d);
    }
}
