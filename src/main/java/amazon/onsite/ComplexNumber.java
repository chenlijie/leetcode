package amazon.onsite;

public class ComplexNumber {

    static String complexNumberMultiply(String s, String t) {
        String[] str = s.split("\\+");
        int a = Integer.valueOf(str[0]);
        int b = Integer.valueOf(str[1].split("i")[0]);

        str = s.split("\\+");
        int c = Integer.valueOf(str[0]);
        int d = Integer.valueOf(str[1].split("i")[0]);

        return (a*c - b*d) + "+" + (a*d + b*c) + "i";
    }

    public static void main(String[] args) {
//        complexNumberMultiply("1+-1i", "0+0i");

        for (String s : "2x+3-4+x-x-3x".split("(?=[-+])"))
        System.out.println(s);

    }
}
